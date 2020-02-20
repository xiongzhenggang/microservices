package com.cmiov.organ.service.impl;

import com.cmiov.organ.mapper.SysOrgMapper;
import com.cmiov.commonentity.PageResult;
import com.cmiov.organ.model.SysOrg;
import com.cmiov.organ.service.ISysOrgService;
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
public class SysOrgServiceImpl extends ServiceImpl<SysOrgMapper, SysOrg> implements ISysOrgService {
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
