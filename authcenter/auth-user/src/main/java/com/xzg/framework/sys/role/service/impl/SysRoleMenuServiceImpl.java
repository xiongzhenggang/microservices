package com.xzg.framework.sys.role.service.impl;

import com.xzg.framework.sys.role.entity.SysRoleMenu;
import com.xzg.framework.sys.role.mapper.SysRoleMenuMapper;
import com.xzg.framework.sys.role.service.ISysRoleMenuService;
import com.xzg.framework.sys.menu.entity.SysMenu;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Set;

/**
 * @autho xzg
 */
@Slf4j
@Service//("roleMenuService")
public class SysRoleMenuServiceImpl extends ServiceImpl<SysRoleMenuMapper, SysRoleMenu> implements ISysRoleMenuService {

	@Resource
	private SysRoleMenuMapper sysRoleMenuMapper;

	@Override
	public int save(Long roleId, Long menuId) {
		return sysRoleMenuMapper.save(roleId, menuId);
	}

	@Override
	public int delete(Long roleId, Long menuId) {
		return sysRoleMenuMapper.delete(roleId, menuId);
	}

	@Override
	public List<SysMenu> findMenusByRoleIds(Set<Long> roleIds, String type) {
		return sysRoleMenuMapper.findMenusByRoleIds(roleIds, type);
	}

	@Override
	public List<SysMenu> findMenusByRoleCodes(Set<String> roleCodes, String type) {
		return sysRoleMenuMapper.findMenusByRoleCodes(roleCodes, type);
	}
}
