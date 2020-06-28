package com.xzg.framework.sys.role.mapper;

import com.xzg.framework.sys.role.entity.SysRole;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
* @autho
 * 角色
 */
public interface SysRoleMapper extends BaseMapper<SysRole> {
	List<SysRole> findList(Page<SysRole> page, @Param("r") Map<String, Object> params);

	/**
	 * 根据组织自购查询
	 * @param orgId
	 * @return
	 */
	List<SysRole> findOrgRoles(@Param("orgId") Long orgId);
}
