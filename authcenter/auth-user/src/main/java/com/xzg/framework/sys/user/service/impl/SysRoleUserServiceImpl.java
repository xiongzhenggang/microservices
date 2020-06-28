package com.xzg.framework.sys.user.service.impl;

import com.xzg.framework.sys.user.mapper.SysUserRoleMapper;
import com.xzg.framework.sys.role.entity.SysRole;
import com.xzg.framework.sys.user.entity.SysRoleUser;
import com.xzg.framework.sys.user.service.ISysRoleUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @autho
 */
@Slf4j
@Service
public class SysRoleUserServiceImpl extends ServiceImpl<SysUserRoleMapper, SysRoleUser> implements ISysRoleUserService {
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
