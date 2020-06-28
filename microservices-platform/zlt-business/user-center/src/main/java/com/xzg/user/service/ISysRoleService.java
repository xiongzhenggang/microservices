package com.xzg.user.service;

import java.util.List;
import java.util.Map;

import com.xzg.common.model.PageResult;
import com.xzg.common.model.Result;
import com.xzg.common.model.SysRole;
import com.xzg.common.service.ISuperService;

/**
* @author
 */
public interface ISysRoleService extends ISuperService<SysRole> {
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
	List<SysRole> findAll();
}
