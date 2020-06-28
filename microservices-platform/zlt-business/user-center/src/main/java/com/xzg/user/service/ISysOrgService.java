package com.xzg.user.service;

import com.xzg.common.model.SysOrg;
import com.xzg.common.model.PageResult;
import com.xzg.common.service.ISuperService;

import java.util.Map;

/**
 * 
 *
 * @author xzg
 * @date 2020-02-13 09:59:34
 */
public interface ISysOrgService extends ISuperService<SysOrg> {
    /**
     * 列表
     * @param params
     * @return
     */
    PageResult<SysOrg> findList(Map<String, Object> params);
}

