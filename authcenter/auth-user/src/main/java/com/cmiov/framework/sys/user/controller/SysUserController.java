package com.cmiov.framework.sys.user.controller;

import com.cmiov.framework.sys.annotation.LoginUserInfo;
import com.cmiov.framework.sys.commonentity.PageResult;
import com.cmiov.framework.sys.commonentity.Result;
import com.cmiov.framework.sys.role.entity.SysRole;
import com.cmiov.framework.sys.user.api.SysUserApi;
import com.cmiov.framework.sys.user.dto.UserPasswordDto;
import com.cmiov.framework.sys.user.entity.*;
import com.cmiov.framework.sys.user.service.ISysUserService;
import com.cmiov.framework.sys.user.dto.LoginAppUser;
import com.cmiov.framework.sys.user.dto.SysUserDto;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.MapUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Map;
import java.util.Set;


/**
 * @author
 * 用户
 */
@Slf4j
@RestController
public class SysUserController implements SysUserApi {
    private static final String ADMIN_CHANGE_MSG = "超级管理员不给予修改";

//    /**
//     * 全文搜索逻辑删除Dto
//     */
//    private static final LogicDelDto SEARCH_LOGIC_DEL_DTO = new LogicDelDto("deleteFlag", "否");

    @Autowired
    private ISysUserService appUserService;



    /**
     * 当前登录用户 LoginAppUser
     *
     * @return
     */
//    @ApiOperation(value = "根据access_token当前登录用户")
//    @GetMapping("/users/current")
    @Override
    public Result<LoginAppUser> getLoginAppUser(@LoginUserInfo(isFull = true) SysUserDto user) {
        return Result.succeed(appUserService.getLoginAppUser(user));
    }

    /**
     * 查询用户实体对象SysUser
     */
    @Override
    public SysUserDto selectByUsername(@PathVariable String username) {
        return appUserService.selectByUsername(username);
    }

    /**
     * 查询用户登录对象LoginAppUser
     */
    @Override
    public LoginAppUser findByUsername(String username) {
        return appUserService.findByUsername(username);
    }


    @Override
    public  Result<SysUser> findUserById(@PathVariable Long id) {

        SysUser sysUser =  appUserService.getById(id);
        sysUser.setPassword(null);
        return Result.succeed(sysUser);
    }

    /**
     * 管理后台修改用户
     *
     * @param sysUser
     */
    //@AuditLog(operation = "'更新用户:' + #sysUser")
    @Override
    public void updateSysUser(@RequestBody SysUser sysUser) {
        appUserService.updateById(sysUser);
    }

    /**
     * 管理后台给用户分配角色
     *
     * @param id
     * @param roleIds
     */
    @Override
    public void setRoleToUser(@PathVariable Long id, @RequestBody Set<Long> roleIds) {
        appUserService.setRoleToUser(id, roleIds);
    }

    /**
     * 获取用户的角色
     *
     * @param
     * @return
     */
    @Override
    public List<SysRole> findRolesByUserId(@PathVariable Long id) {
        return appUserService.findRolesByUserId(id);
    }

    /**
     * 用户查询
     *
     * @param params
     * @return
     */
//    @ApiImplicitParams({
//            @ApiImplicitParam(name = "page", value = "分页起始位置", required = true, dataType = "Integer"),
//            @ApiImplicitParam(name = "limit", value = "分页结束位置", required = true, dataType = "Integer")
//    })
    @Override
    public PageResult<SysUser> findUsers(@RequestParam Map<String, Object> params) {
        return appUserService.findUsers(params);
    }

    /**
     * 修改用户状态
     *
     * @param params
     * @return
     */
    @Override
    public Result updateEnabled(@RequestParam Map<String, Object> params) {
        Long id = MapUtils.getLong(params, "id");
        if (checkAdmin(id)) {
            return Result.failed(ADMIN_CHANGE_MSG);
        }
        return appUserService.updateEnabled(params);
    }

    /**
     * 管理后台，给用户重置密码
     *
     * @param id
     */
    @Override
    public Result resetPassword(@PathVariable Long id) {
        if (checkAdmin(id)) {
            return Result.failed(ADMIN_CHANGE_MSG);
        }
        appUserService.updatePassword(id, null, null);
        return Result.succeed("重置成功");
    }

    /**
     * 用户自己修改密码
     */
    @Override
    public Result resetPassword(@LoginUserInfo SysUserDto currentUser, UserPasswordDto dto) {
        if (checkAdmin(currentUser.getId())) {
            return Result.failed(ADMIN_CHANGE_MSG);
        }
        appUserService.updatePassword(currentUser.getId(), dto.getOldPassword(), dto.getNewPassword());
        return Result.succeed("重置成功");
    }

    /**
     * 删除用户
     *
     * @param id
     */
    @Override
    public Result delete(@PathVariable Long id) {
        if (checkAdmin(id)) {
            return Result.failed(ADMIN_CHANGE_MSG);
        }
        appUserService.delUser(id);
        return Result.succeed("删除成功");
    }

    /**
     * 新增or更新
     *
     * @param sysUser
     * @return
     */
//    @AuditLog(operation = "'新增或更新用户:' + #sysUser.username")
    @Override
    public Result saveOrUpdate(@RequestBody SysUser sysUser,@LoginUserInfo(isFull = true) SysUserDto currentUser) {
        return appUserService.saveOrUpdateUser(sysUser,currentUser);
    }

    /**
     * 是否超级管理员
     */
    private boolean checkAdmin(long id) {
        return id == 1L;
    }
}
