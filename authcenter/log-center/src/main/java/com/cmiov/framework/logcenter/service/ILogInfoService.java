package com.cmiov.framework.logcenter.service;

import com.cmiov.framework.logcenter.dto.AuditLogDto;
import com.cmiov.framework.logcenter.entity.LogInfo;
import com.cmiov.framework.logcenter.model.PageResult;
import com.cmiov.framework.logcenter.model.Result;

import java.util.List;
import java.util.Map;

/**
 * @author xzg
 */
public interface ILogInfoService  {

    PageResult<LogInfo> searchAuditLog(Map<String, Object> params);

    Result<String> saveAuditLog(AuditLogDto dto);
}
