package com.xzg.framework.sys.user.service;

import com.xzg.framework.sys.commonentity.PageResult;
import com.xzg.framework.sys.user.entity.SysAuthData;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.Map;

/**
 * 
 *
 * @author xzg
 * @date 2020-02-13 09:59:34
 */
public interface ISysAuthDataService extends IService<SysAuthData> {
    /**
     * 列表
     * @param params
     * @return
     */
    PageResult<SysAuthData> findList(Map<String, Object> params);
}

