package com.cmiov.framework.logcenter.controller;

import com.cmiov.framework.logcenter.api.AuditLogApi;
import com.cmiov.framework.logcenter.dto.AuditLogDto;
import com.cmiov.framework.logcenter.entity.LogInfo;
import com.cmiov.framework.logcenter.model.PageResult;
import com.cmiov.framework.logcenter.model.Result;
import com.cmiov.framework.logcenter.service.ILogInfoService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;
import java.util.Objects;

/**
 * 审计日志
 *
 * @autho
 * @date 2020/3/2
 * <p>
 */
@Slf4j
@RestController
public class AuditLogController implements AuditLogApi {

    @Autowired
    private ILogInfoService iLogInfoService;
    @Override
    public PageResult<LogInfo> list(Map<String, Object> params) {
        return iLogInfoService.searchAuditLog(params);
    }

    @Override
    public Result save(AuditLogDto dto) {
        if(Objects.nonNull(dto)){
            return Result.failed("参数为空！");
        }
        return iLogInfoService.saveAuditLog(dto);
    }
}
