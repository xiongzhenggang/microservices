package com.xzg.framework.sys.menu.api;

import com.xzg.framework.sys.annotation.LoginUserInfo;
import com.xzg.framework.sys.commonentity.PageResult;
import com.xzg.framework.sys.commonentity.Result;
import com.xzg.framework.sys.menu.entity.SysMenu;
import com.xzg.framework.sys.user.dto.SysUserDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.*;

import java.util.*;

/**
 * @author
 */
@RestController
@Api(tags = "菜单模块api")
@RequestMapping("/menus")
public interface SysMenuApi {


    /**
     * 删除菜单
     *
     * @param id
     */
    @ApiOperation(value = "删除菜单")
    @DeleteMapping("/{id}")
    Result delete(@PathVariable Long id);

    @ApiOperation(value = "根据roleId获取对应的菜单")
    @GetMapping("/{roleId}/menus")
     List<Map<String, Object>> findMenusByRoleId(@PathVariable Long roleId);

    @ApiOperation(value = "根据roleCodes获取对应的权限")
    @Cacheable(value = "menu", key ="#roleCodes")
    @GetMapping("/{roleCodes}")
     List<SysMenu> findMenuByRoles(@PathVariable String roleCodes) ;

    /**
     * 给角色分配菜单
     */
    @ApiOperation(value = "角色分配菜单")
    @PostMapping("/granted")
    public Result setMenuToRole(@RequestBody SysMenu sysMenu);

    @ApiOperation(value = "查询所有菜单")
    @GetMapping("/findAlls")
    List<SysMenu>  findAlls() ;

    @ApiOperation(value = "获取菜单以及顶级菜单")
    @GetMapping("/findOnes")
    PageResult<SysMenu> findOnes();

    /**
     * 添加菜单 或者 更新
     *
     * @param menu
     * @return
     */
    @ApiOperation(value = "新增菜单")
    @PostMapping("saveOrUpdate")
     Result saveOrUpdate(@RequestBody SysMenu menu);

    /**
     * 当前登录用户的菜单
     *
     * @return
     */
    @GetMapping("/current")
    @ApiOperation(value = "查询当前用户菜单")
    Result<List<SysMenu>> findMyMenu(@LoginUserInfo SysUserDto user);
}
