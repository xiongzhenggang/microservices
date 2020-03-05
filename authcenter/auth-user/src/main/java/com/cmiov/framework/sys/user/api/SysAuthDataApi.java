package com.cmiov.framework.sys.user.api;

import com.cmiov.framework.sys.commonentity.PageResult;
import com.cmiov.framework.sys.commonentity.Result;
import com.cmiov.framework.sys.user.entity.SysAuthData;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * 
 *
 * @author xzg
 * @date 2020-02-13 09:59:34
 */
@RestController
@RequestMapping("/sysauthdata")
@Api(tags = "")
public interface SysAuthDataApi {

    /**
     * 列表
     */
    @ApiOperation(value = "查询列表")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "page", value = "分页起始位置", required = true, dataType = "Integer"),
            @ApiImplicitParam(name = "limit", value = "分页结束位置", required = true, dataType = "Integer")
    })
    @GetMapping
    PageResult list(@RequestParam Map<String, Object> params);

    /**
     * 查询
     */
    @ApiOperation(value = "查询")
    @GetMapping("/{id}")
    Result findUserById(@PathVariable(value="id") Long id) ;

    /**
     * 新增or更新
     */
    @ApiOperation(value = "保存")
    @PostMapping
     Result save(@RequestBody SysAuthData sysAuthData);

    /**
     * 删除
     */
    @ApiOperation(value = "删除")
    @DeleteMapping("/{id}")
     Result delete(@PathVariable(value="id") Long id) ;
}
