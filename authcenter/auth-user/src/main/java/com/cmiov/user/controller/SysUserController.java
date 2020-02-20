package com.cmiov.user.controller;

import cmiov.user.model.*;
import com.cmiov.user.model.*;
import com.cmiov.user.service.ISysUserService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.MapUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
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
public class SysUserController {
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
    @GetMapping("/users/current")
    public Result<LoginAppUser> getLoginAppUser(SysUser user) {
        return Result.succeed(appUserService.getLoginAppUser(user));
    }

    /**
     * 查询用户实体对象SysUser
     */
    @GetMapping(value = "/users/name/{username}")
//    @ApiOperation(value = "根据用户名查询用户实体")
    @Cacheable(value = "user", key = "#username")
    public SysUser selectByUsername(@PathVariable String username) {
        return appUserService.selectByUsername(username);
    }

    /**
     * 查询用户登录对象LoginAppUser
     */
    @GetMapping(value = "/users-anon/login", params = "username")
    public LoginAppUser findByUsername(String username) {
        return appUserService.findByUsername(username);
    }


    @GetMapping("/users/{id}")
    public SysUser findUserById(@PathVariable Long id) {
        return appUserService.getById(id);
    }

    /**
     * 管理后台修改用户
     *
     * @param sysUser
     */
    @PutMapping("/users")
    @CachePut(value = "user", key = "#sysUser.username", unless="#result == null")
    //@AuditLog(operation = "'更新用户:' + #sysUser")
    public void updateSysUser(@RequestBody SysUser sysUser) {
        appUserService.updateById(sysUser);
    }

    /**
     * 管理后台给用户分配角色
     *
     * @param id
     * @param roleIds
     */
    @PostMapping("/users/{id}/roles")
    public void setRoleToUser(@PathVariable Long id, @RequestBody Set<Long> roleIds) {
        appUserService.setRoleToUser(id, roleIds);
    }

    /**
     * 获取用户的角色
     *
     * @param
     * @return
     */
    @GetMapping("/users/{id}/roles")
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
    @GetMapping("/users")
    public PageResult<SysUser> findUsers(@RequestParam Map<String, Object> params) {
        return appUserService.findUsers(params);
    }

    /**
     * 修改用户状态
     *
     * @param params
     * @return
     */
    @GetMapping("/users/updateEnabled")
//    @ApiImplicitParams({
//            @ApiImplicitParam(name = "id", value = "用户id", required = true, dataType = "Integer"),
//            @ApiImplicitParam(name = "enabled", value = "是否启用", required = true, dataType = "Boolean")
//    })
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
    @PutMapping(value = "/users/{id}/password")
    //@AuditLog(operation = "'重置用户密码:' + #id")
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
    @PutMapping(value = "/users/password")
    public Result resetPassword(@RequestBody SysUser sysUser) {
        if (checkAdmin(sysUser.getId())) {
            return Result.failed(ADMIN_CHANGE_MSG);
        }
        appUserService.updatePassword(sysUser.getId(), sysUser.getOldPassword(), sysUser.getNewPassword());
        return Result.succeed("重置成功");
    }

    /**
     * 删除用户
     *
     * @param id
     */
    @DeleteMapping(value = "/users/{id}")
    //@AuditLog(operation = "'删除用户:' + #id")
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
    @CacheEvict(value = "user", key = "#sysUser.username")
    @PostMapping("/users/saveOrUpdate")
//    @AuditLog(operation = "'新增或更新用户:' + #sysUser.username")
    public Result saveOrUpdate(@RequestBody SysUser sysUser) {
        return appUserService.saveOrUpdateUser(sysUser);
    }

    /**
     * 是否超级管理员
     */
    private boolean checkAdmin(long id) {
        return id == 1L;
    }
}
