package com.cmiov.framework.sys.organ.api;

import com.cmiov.framework.sys.commonentity.PageResult;
import com.cmiov.framework.sys.commonentity.Result;
import com.cmiov.framework.sys.organ.dto.AssignRoleDto;
import com.cmiov.framework.sys.organ.entity.SysOrg;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * 
 *
 * @author xzg
 * @date 2020-02-13 09:59:34
 */
@RestController
@RequestMapping("/sysorg")
@Api(tags = "")
public interface SysOrgApi {

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
    Result findUserById(@PathVariable Long id);

    /**
     * 新增or更新
     */
    @ApiOperation(value = "保存")
    @PostMapping
     Result save(@RequestBody SysOrg sysOrg) ;

    /**
     * 新增or更新
     */
    @ApiOperation(value = "分配角色")
    @PostMapping("/assign/roles")
    Result assignRole(@RequestBody AssignRoleDto dto) ;
    /**
     * 删除
     */
    @ApiOperation(value = "删除")
    @DeleteMapping("/{id}")
     Result delete(@PathVariable Long id);
}
