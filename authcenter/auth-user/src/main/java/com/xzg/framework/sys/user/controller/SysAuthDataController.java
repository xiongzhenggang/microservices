package com.xzg.framework.sys.user.controller;

import com.xzg.framework.sys.commonentity.PageResult;
import com.xzg.framework.sys.commonentity.Result;
import com.xzg.framework.sys.user.api.SysAuthDataApi;
import com.xzg.framework.sys.user.entity.SysAuthData;
import com.xzg.framework.sys.user.service.ISysAuthDataService;
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
@RequestMapping("/sysauthdata")
public class SysAuthDataController implements SysAuthDataApi {
    @Autowired
    private ISysAuthDataService sysAuthDataService;

    /**
     * 列表
     */
//    @ApiImplicitParams({
//            @ApiImplicitParam(name = "page", value = "分页起始位置", required = true, dataType = "Integer"),
//            @ApiImplicitParam(name = "limit", value = "分页结束位置", required = true, dataType = "Integer")
//    })
    @Override
    public PageResult list(@RequestParam Map<String, Object> params) {
        return sysAuthDataService.findList(params);
    }

    /**
     * 查询
     */
    @Override
    public Result findUserById(@PathVariable Long id) {
        SysAuthData model = sysAuthDataService.getById(id);
        return Result.succeed(model, "查询成功");
    }

    /**
     * 新增or更新
     */
    @Override
    public Result save(@RequestBody SysAuthData sysAuthData) {
        sysAuthDataService.saveOrUpdate(sysAuthData);
        return Result.succeed("保存成功");
    }

    /**
     * 删除
     */
    @Override
    public Result delete(@PathVariable Long id) {
        sysAuthDataService.removeById(id);
        return Result.succeed("删除成功");
    }
}
