package com.cmiov.user.service;

import com.cmiov.user.model.PageResult;
import com.cmiov.user.model.Result;
import com.cmiov.user.model.SysRole;
import com.baomidou.mybatisplus.extension.service.IService;

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
	List<SysRole> findAll();
}
