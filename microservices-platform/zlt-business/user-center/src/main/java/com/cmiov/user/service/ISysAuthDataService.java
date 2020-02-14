package com.cmiov.user.service;

import com.cmiov.common.model.SysAuthData;
import com.cmiov.common.model.PageResult;
import com.cmiov.common.service.ISuperService;

import java.util.Map;

/**
 * 
 *
 * @author xzg
 * @date 2020-02-13 09:59:34
 */
public interface ISysAuthDataService extends ISuperService<SysAuthData> {
    /**
     * 列表
     * @param params
     * @return
     */
    PageResult<SysAuthData> findList(Map<String, Object> params);
}

