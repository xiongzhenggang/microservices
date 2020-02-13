package com.central.user.service.impl;

import com.central.common.model.SysOrg;
import org.springframework.stereotype.Service;
import com.central.common.model.PageResult;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.central.common.service.impl.SuperServiceImpl;

import java.util.List;
import java.util.Map;
import org.apache.commons.collections4.MapUtils;
import lombok.extern.slf4j.Slf4j;

import com.central.user.mapper.SysOrgMapper;
import com.central.user.service.ISysOrgService;

/**
 * 
 *
 * @author xzg
 * @date 2020-02-13 09:59:34
 */
@Slf4j
@Service
public class SysOrgServiceImpl extends SuperServiceImpl<SysOrgMapper, SysOrg> implements ISysOrgService {
    /**
     * 列表
     * @param params
     * @return
     */
    @Override
    public PageResult<SysOrg> findList(Map<String, Object> params){
        Page<SysOrg> page = new Page<>(MapUtils.getInteger(params, "page"), MapUtils.getInteger(params, "limit"));
        List<SysOrg> list  =  baseMapper.findList(page, params);
        return PageResult.<SysOrg>builder().data(list).code(0).count(page.getTotal()).build();
    }
}
