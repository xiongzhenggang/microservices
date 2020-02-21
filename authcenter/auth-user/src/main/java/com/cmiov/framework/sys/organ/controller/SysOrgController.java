package com.cmiov.framework.sys.organ.controller;

import com.cmiov.framework.sys.commonentity.PageResult;
import com.cmiov.framework.sys.commonentity.Result;
import com.cmiov.framework.sys.organ.api.SysOrgApi;
import com.cmiov.framework.sys.organ.entity.SysOrg;
import com.cmiov.framework.sys.organ.service.ISysOrgService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * 
 *
 * @author xzg
 * @date 2020-02-13 09:59:34
 */
@Slf4j
@RestController
@RequestMapping("/sysorg")
public class SysOrgController implements SysOrgApi {
    @Autowired
    private ISysOrgService sysOrgService;

    /**
     * 列表
     */
//    @ApiImplicitParams({
//            @ApiImplicitParam(name = "page", value = "分页起始位置", required = true, dataType = "Integer"),
//            @ApiImplicitParam(name = "limit", value = "分页结束位置", required = true, dataType = "Integer")
//    })
    @Override
    public PageResult list(@RequestParam Map<String, Object> params) {
        return sysOrgService.findList(params);
    }

    /**
     * 查询
     */
    @Override
    public Result findUserById(@PathVariable Long id) {
        SysOrg model = sysOrgService.getById(id);
        return Result.succeed(model, "查询成功");
    }

    /**
     * 新增or更新
     */
    @Override
    public Result save(@RequestBody SysOrg sysOrg) {
        sysOrgService.saveOrUpdate(sysOrg);
        return Result.succeed("保存成功");
    }

    /**
     * 删除
     */
    @Override
    public Result delete(@PathVariable Long id) {
        sysOrgService.removeById(id);
        return Result.succeed("删除成功");
    }
}
