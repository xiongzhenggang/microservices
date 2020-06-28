package com.xzg.user.service;

import com.xzg.common.model.SysMenu;
import com.xzg.common.service.ISuperService;
import com.xzg.user.model.SysRoleMenu;

import java.util.List;
import java.util.Set;

/**
 * @autho
 */
public interface ISysRoleMenuService extends ISuperService<SysRoleMenu> {
	int save(Long roleId, Long menuId);

	int delete(Long roleId, Long menuId);

	List<SysMenu> findMenusByRoleIds(Set<Long> roleIds, String type);

	List<SysMenu> findMenusByRoleCodes(Set<String> roleCodes, String type);
}
