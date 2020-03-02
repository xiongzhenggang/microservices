package com.cmiov.framework.sys.role.controller;

import com.cmiov.framework.sys.annotation.LoginUserInfo;
import com.cmiov.framework.sys.commonentity.PageResult;
import com.cmiov.framework.sys.commonentity.Result;
import com.cmiov.framework.sys.role.api.SysRoleApi;
import com.cmiov.framework.sys.role.entity.SysRole;
import com.cmiov.framework.sys.role.service.ISysRoleService;
import com.cmiov.framework.sys.user.dto.SysUserDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * @author
 * 角色管理
 */
@Slf4j
@RestController
public class SysRoleController implements SysRoleApi {
    @Autowired
    private ISysRoleService sysRoleService;

    /**
     * 后台管理查询角色
     * @param params
     * @return
     */
    @Override
    public PageResult<SysRole> findRoles(@RequestParam Map<String, Object> params) {
        return sysRoleService.findRoles(params);
    }

    /**
     * 用户管理查询所有角色
     * @return
     */
    @Override
    public Result<List<SysRole>> findCurrentOrgRoles(@LoginUserInfo(isFull = true) SysUserDto sysUserDto, @RequestParam(required = false) Long orgId) {
        if(null == orgId){
           orgId = sysUserDto.getOrgId();
        }
        List<SysRole> result = sysRoleService.findOrgRoleAll(orgId);
        return Result.succeed(result);
    }

    /**
     * 角色新增或者更新
     *
     * @param sysRole
     * @return
     */
    @Override
    public Result saveOrUpdate(@RequestBody SysRole sysRole) {
        return sysRoleService.saveOrUpdateRole(sysRole);
    }

    /**
     * 后台管理删除角色
     * delete /role/1
     *
     * @param id
     */
    @Override
    public Result deleteRole(@PathVariable Long id) {
        try {
            if (id == 1L) {
                return Result.failed("管理员不可以删除");
            }
            sysRoleService.deleteRole(id);
            return Result.succeed("操作成功");
        } catch (Exception e) {
            log.error("role-deleteRole-error", e);
            return Result.failed("操作失败");
        }
    }
}
