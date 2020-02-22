package com.cmiov.framework.sys.organ.service;

import com.cmiov.framework.sys.commonentity.PageResult;
import com.cmiov.framework.sys.organ.entity.SysOrg;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.Map;

/**
 * 
 *
 * @author xzg
 * @date 2020-02-13 09:59:34
 */
public interface ISysOrgService extends IService<SysOrg> {
    /**
     * 列表
     * @param params
     * @return
     */
    PageResult<SysOrg> findList(Map<String, Object> params);
}
