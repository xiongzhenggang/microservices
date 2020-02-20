package com.cmiov.user.service.impl;

import com.cmiov.user.mapper.SysAuthDataMapper;
import com.cmiov.commonentity.PageResult;
import com.cmiov.user.model.SysAuthData;
import com.cmiov.user.service.ISysAuthDataService;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.MapUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * 
 *
 * @author xzg
 * @date 2020-02-13 09:59:34
 */
@Slf4j
@Service
public class SysAuthDataServiceImpl extends ServiceImpl<SysAuthDataMapper, SysAuthData> implements ISysAuthDataService {
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
