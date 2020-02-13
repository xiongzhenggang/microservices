package com.central.user.service;

import com.central.common.model.SysAuthData;
import com.central.common.model.PageResult;
import com.central.common.service.ISuperService;

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

