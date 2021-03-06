package com.xzg.framework.logcenter.controller;

import com.xzg.framework.logcenter.api.AuditLogApi;
import com.xzg.framework.logcenter.dto.SearchDto;
import com.xzg.framework.logcenter.dto.AuditLogDto;
import com.xzg.framework.logcenter.entity.LogInfo;
import com.xzg.framework.logcenter.model.PageResult;
import com.xzg.framework.logcenter.model.Result;
import com.xzg.framework.logcenter.service.ILogInfoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
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
        if(Objects.isNull(dto)){
            return Result.failed("参数为空！");
        }
        return iLogInfoService.saveAuditLog(dto);
    }

    @Override
    public PageResult getPage(SearchDto searchDto) {

        return null;
    }
}
