package com.cmiov.log.service;

import com.cmiov.log.model.Audit;

/**
 * 审计日志接口
 *
 * @autho
 * @date 2020/2/3
 * <p>
 */
public interface IAuditService {
    void save(Audit audit);
}
