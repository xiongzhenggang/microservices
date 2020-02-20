package com.cmiov.user.service;

import com.cmiov.user.model.SysRole;
import com.cmiov.user.model.SysRoleUser;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * @autho
 */
public interface ISysRoleUserService extends IService<SysRoleUser> {
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
