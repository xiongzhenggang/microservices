package com.cmiov.user.service;

import com.cmiov.common.model.SysMenu;
import com.cmiov.common.service.ISuperService;
import com.cmiov.user.model.SysRoleMenu;

import java.util.List;
import java.util.Set;

/**
 * @autho
 */
public interface ISysRoleMenuService extends ISuperService<SysRoleMenu> {
	int save(Long roleId, Long menuId);

	int delete(Long roleId, Long menuId);

	List<SysMenu> findMenusByRoleIds(Set<Long> roleIds, Integer type);

	List<SysMenu> findMenusByRoleCodes(Set<String> roleCodes, Integer type);
}
