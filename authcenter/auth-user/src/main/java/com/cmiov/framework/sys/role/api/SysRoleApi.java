package com.cmiov.framework.sys.role.api;

import com.cmiov.framework.sys.annotation.LoginUserInfo;
import com.cmiov.framework.sys.commonentity.PageResult;
import com.cmiov.framework.sys.commonentity.Result;
import com.cmiov.framework.sys.role.entity.SysRole;
import com.cmiov.framework.sys.user.dto.SysUserDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * @author
 * 角色管理
 */
@RestController
@RequestMapping("/roles")
@Api(tags = "角色模块api")
public interface SysRoleApi {

    /**
     * 后台管理查询角色
     * @param params
     * @return
     */
    @ApiOperation(value = "后台管理查询角色")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "page", value = "分页起始位置", required = true, dataType = "Integer"),
            @ApiImplicitParam(name = "limit", value = "分页结束位置", required = true, dataType = "Integer")
    })
    @GetMapping("")
    PageResult<SysRole> findRoles(@RequestParam Map<String, Object> params) ;

    /**
     * 用户管理查询所有角色
     * @return
     */
    @ApiOperation(value = "查询当前组织机构下得角色列表")
    @GetMapping("/org/roles")
     Result<List<SysRole>> findCurrentOrgRoles(@LoginUserInfo(isFull = true)SysUserDto sysUserDto,@RequestParam(required = false) Long orgId);

    /**
     * 角色新增或者更新
     *
     * @param sysRole
     * @return
     */
    @PostMapping("/saveOrUpdate")
     Result saveOrUpdate(@RequestBody SysRole sysRole);

    /**
     * 后台管理删除角色
     * delete /role/1
     *
     * @param id
     */
    @ApiOperation(value = "后台管理删除角色")
    @DeleteMapping("/{id}")
     Result deleteRole(@PathVariable(value="id") Long id);
}
