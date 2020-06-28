package com.xzg.framework.logcenter.service;

import com.xzg.framework.logcenter.dto.AuditLogDto;
import com.xzg.framework.logcenter.entity.LogInfo;
import com.xzg.framework.logcenter.model.PageResult;
import com.xzg.framework.logcenter.model.Result;

import java.util.Map;

/**
 * @author xzg
 */
public interface ILogInfoService  {

    PageResult<LogInfo> searchAuditLog(Map<String, Object> params);

    Result<String> saveAuditLog(AuditLogDto dto);
}
