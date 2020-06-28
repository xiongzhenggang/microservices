package com.xzg.user.service;

import com.xzg.common.model.SysRole;
import com.xzg.common.service.ISuperService;
import com.xzg.user.model.SysRoleUser;

import java.util.List;

/**
 * @autho
 */
public interface ISysRoleUserService extends ISuperService<SysRoleUser> {
	int deleteUserRole(Long userId, Long roleId);

	int saveUserRoles(Long userId, Long roleId);

	/**
	 * 根据用户id获取角色
	 *
	 * @param userId
	 * @return
	 */
	List<SysRole> findRolesByUserId(Long userId);

	/**
	 * 根据用户ids 获取
	 *
	 * @param userIds
	 * @return
	 */
	List<SysRole> findRolesByUserIds(List<Long> userIds);
}
