package com.xzg.framework.sys.role.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xzg.framework.sys.commonentity.PageResult;
import com.xzg.framework.sys.commonentity.Result;
import com.xzg.framework.sys.role.entity.SysRole;

import java.util.List;
import java.util.Map;

/**
* @author
 */
public interface ISysRoleService extends IService<SysRole> {
	void saveRole(SysRole sysRole);

	void deleteRole(Long id);

	/**
	 * 角色列表
	 * @param params
	 * @return
	 */
	PageResult<SysRole> findRoles(Map<String, Object> params);

	/**
	 * 新增或更新角色
	 * @param sysRole
	 * @return Result
	 */
	Result saveOrUpdateRole(SysRole sysRole);

	/**
	 * 查询所有角色
	 * @return
	 */
	List<SysRole> findOrgRoleAll(Long orgId);
}
