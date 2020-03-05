package com.cmiov.framework.sys.organ.service.impl;

import com.cmiov.framework.sys.commonentity.PageResult;
import com.cmiov.framework.sys.commonentity.Result;
import com.cmiov.framework.sys.organ.service.ISysOrgService;
import com.cmiov.framework.sys.organ.mapper.SysOrgMapper;
import com.cmiov.framework.sys.organ.entity.SysOrg;
import com.cmiov.framework.sys.organ.mapper.SysOrgRoleRelMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.MapUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;
import java.util.Set;

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
    @Resource
    private SysOrgRoleRelMapper sysOrgRoleRelMapper;
    @Override
    public PageResult<SysOrg> findList(Map<String, Object> params){
        Page<SysOrg> page = new Page<>(MapUtils.getInteger(params, "page"), MapUtils.getInteger(params, "limit"));
        List<SysOrg> list  =  baseMapper.findList(page, params);
        return PageResult.<SysOrg>builder().data(list).code(0).count(page.getTotal()).build();
    }

    @Override
    public Result assignRole2Org(Long orgId, Set<Long> roleIds){
        if(!CollectionUtils.isEmpty(roleIds)){
            sysOrgRoleRelMapper.insertOrgRole(orgId,roleIds);
        }
        return Result.succeed("操作成功");
    }

}
