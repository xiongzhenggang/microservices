package com.cmiov.framework.sys.user.api;

import com.cmiov.framework.sys.commonentity.PageResult;
import com.cmiov.framework.sys.commonentity.Result;
import com.cmiov.framework.sys.role.entity.SysRole;
import com.cmiov.framework.sys.user.entity.LoginAppUser;
import com.cmiov.framework.sys.user.entity.SysUser;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
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
@RestController
@Api(tags = "用户模块api")
public interface SysUserApi {


//    /**
//     * 当前登录用户 LoginAppUser
//     *
//     * @return
//     */
//    @ApiOperation(value = "根据access_token当前登录用户")
//    @GetMapping("/users/current")
//    public Result<LoginAppUser> getLoginAppUser(@LoginUser(isFull = true) SysUser user) {
//        return Result.succeed(appUserService.getLoginAppUser(user));
//    }

    /**
     * 查询用户实体对象SysUser
     */
    @GetMapping(value = "/users/name/{username}")
    @ApiOperation(value = "根据用户名查询用户实体")
    @Cacheable(value = "user", key = "#username")
     SysUser selectByUsername(@PathVariable String username) ;

    /**
     * 查询用户登录对象LoginAppUser
     */
    @GetMapping(value = "/users-anon/login", params = "username")
    @ApiOperation(value = "根据用户名查询用户")
    LoginAppUser findByUsername(String username);

//    /**
//     * 通过手机号查询用户、角色信息
//     *
//     * @param mobile 手机号
//     */
//    @GetMapping(value = "/users-anon/mobile", params = "mobile")
//    @ApiOperation(value = "根据手机号查询用户")
//     SysUser findByMobile(String mobile);


    @GetMapping("/users/{id}")
     SysUser findUserById(@PathVariable Long id);

    /**
     * 管理后台修改用户
     *
     * @param sysUser
     */
    @PutMapping("/users")
    @CachePut(value = "user", key = "#sysUser.username", unless="#result == null")
    //@AuditLog(operation = "'更新用户:' + #sysUser")
     void updateSysUser(@RequestBody SysUser sysUser);

    /**
     * 管理后台给用户分配角色
     *
     * @param id
     * @param roleIds
     */
    @PostMapping("/users/{id}/roles")
     void setRoleToUser(@PathVariable Long id, @RequestBody Set<Long> roleIds) ;

    /**
     * 获取用户的角色
     *
     * @param
     * @return
     */
    @GetMapping("/users/{id}/roles")
    List<SysRole> findRolesByUserId(@PathVariable Long id);

    /**
     * 用户查询
     *
     * @param params
     * @return
     */
    @ApiOperation(value = "用户查询列表")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "page", value = "分页起始位置", required = true, dataType = "Integer"),
            @ApiImplicitParam(name = "limit", value = "分页结束位置", required = true, dataType = "Integer")
    })
    @GetMapping("/users")
    public PageResult<SysUser> findUsers(@RequestParam Map<String, Object> params);
    /**
     * 修改用户状态
     *
     * @param params
     * @return
     */
    @ApiOperation(value = "修改用户状态")
    @GetMapping("/users/updateEnabled")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "用户id", required = true, dataType = "Integer"),
            @ApiImplicitParam(name = "enabled", value = "是否启用", required = true, dataType = "Boolean")
    })
    Result updateEnabled(@RequestParam Map<String, Object> params);

    /**
     * 管理后台，给用户重置密码
     *
     * @param id
     */
    @PutMapping(value = "/users/{id}/password")
    //@AuditLog(operation = "'重置用户密码:' + #id")
     Result resetPassword(@PathVariable Long id);

    /**
     * 用户自己修改密码
     */
    @PutMapping(value = "/users/password")
     Result resetPassword(@RequestBody SysUser sysUser);

    /**
     * 删除用户
     *
     * @param id
     */
    @DeleteMapping(value = "/users/{id}")
    //@AuditLog(operation = "'删除用户:' + #id")
    public Result delete(@PathVariable Long id) ;


    /**
     * 新增or更新
     *
     * @param sysUser
     * @return
     */
    @CacheEvict(value = "user", key = "#sysUser.username")
    @PostMapping("/users/saveOrUpdate")
    public Result saveOrUpdate(@RequestBody SysUser sysUser);

}
