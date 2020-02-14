package com.cmiov.user.service;

import java.util.List;
import java.util.Map;

import com.cmiov.common.model.PageResult;
import com.cmiov.common.model.Result;
import com.cmiov.common.model.SysRole;
import com.cmiov.common.service.ISuperService;

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
