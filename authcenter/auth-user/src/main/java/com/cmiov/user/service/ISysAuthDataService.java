package com.cmiov.user.service;

import com.cmiov.commonentity.PageResult;
import com.cmiov.user.model.SysAuthData;
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

