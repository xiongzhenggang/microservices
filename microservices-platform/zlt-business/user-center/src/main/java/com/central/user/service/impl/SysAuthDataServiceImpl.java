package com.central.user.service.impl;

import com.central.common.model.SysAuthData;
import com.central.common.service.impl.SuperServiceImpl;
import org.springframework.stereotype.Service;
import com.central.common.model.PageResult;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import java.util.List;
import java.util.Map;
import org.apache.commons.collections4.MapUtils;
import lombok.extern.slf4j.Slf4j;

import com.central.user.mapper.SysAuthDataMapper;
import com.central.user.service.ISysAuthDataService;

/**
 * 
 *
 * @author xzg
 * @date 2020-02-13 09:59:34
 */
@Slf4j
@Service
public class SysAuthDataServiceImpl extends SuperServiceImpl<SysAuthDataMapper, SysAuthData> implements ISysAuthDataService {
    /**
     * 列表
     * @param params
     * @return
     */
    @Override
    public PageResult<SysAuthData> findList(Map<String, Object> params){
        Page<SysAuthData> page = new Page<>(MapUtils.getInteger(params, "page"), MapUtils.getInteger(params, "limit"));
        List<SysAuthData> list  =  baseMapper.findList(page, params);
        return PageResult.<SysAuthData>builder().data(list).code(0).count(page.getTotal()).build();
    }
}
