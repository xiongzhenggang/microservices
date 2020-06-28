package com.xzg.user.service.impl;

import com.xzg.common.model.SysRole;
import com.xzg.common.service.impl.SuperServiceImpl;
import com.xzg.user.mapper.SysUserRoleMapper;
import com.xzg.user.model.SysRoleUser;
import com.xzg.user.service.ISysRoleUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @autho
 */
@Slf4j
@Service
public class SysRoleUserServiceImpl extends SuperServiceImpl<SysUserRoleMapper, SysRoleUser> implements ISysRoleUserService {
 	@Resource
	private SysUserRoleMapper sysUserRoleMapper;

	@Override
	public int deleteUserRole(Long userId, Long roleId) {
		return sysUserRoleMapper.deleteUserRole(userId, roleId);
	}

	@Override
	public int saveUserRoles(Long userId, Long roleId) {
		return sysUserRoleMapper.saveUserRoles(userId, roleId);
	}

	@Override
	public List<SysRole> findRolesByUserId(Long userId) {
		return sysUserRoleMapper.findRolesByUserId(userId);
	}

	@Override
	public List<SysRole> findRolesByUserIds(List<Long> userIds) {
		return sysUserRoleMapper.findRolesByUserIds(userIds);
	}
}
