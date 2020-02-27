package com.cmiov.framework.sys.organ.mapper;

import com.cmiov.framework.sys.organ.entity.SysOrgRoleRel;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 
 * 
 * @author xzg
 * @date 2020-02-13 09:59:34
 */
public interface SysOrgRoleRelMapper extends BaseMapper<SysOrgRoleRel> {
    /**
     * 分页查询用户列表
     * @param page
     * @param params
     * @return
     */
    List<SysOrgRoleRel> findList(Page<SysOrgRoleRel> page, @Param("p") Map<String, Object> params);

    //为赋予组织机构角色
     void insertOrgRole(@Param(value = "orgId") Long orgId, @Param(value = "roleIds") Set<Long> roleIds);
}
