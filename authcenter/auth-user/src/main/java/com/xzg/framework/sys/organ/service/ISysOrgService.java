package com.xzg.framework.sys.organ.service;

import com.xzg.framework.sys.commonentity.PageResult;
import com.xzg.framework.sys.commonentity.Result;
import com.xzg.framework.sys.organ.entity.SysOrg;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.Map;
import java.util.Set;

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

    Result assignRole2Org(Long orgId, Set<Long> roleIds);
}

