package com.xzg.framework.sys.user.service.impl;

import com.xzg.framework.sys.commonentity.PageResult;
import com.xzg.framework.sys.user.service.ISysAuthDataService;
import com.xzg.framework.sys.user.mapper.SysAuthDataMapper;
import com.xzg.framework.sys.user.entity.SysAuthData;
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
