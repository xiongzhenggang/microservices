package com.cmiov.role.service;

import com.cmiov.menu.model.SysMenu;
import com.cmiov.role.model.SysRoleMenu;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;
import java.util.Set;

/**
 * @autho
 */
public interface ISysRoleMenuService extends IService<SysRoleMenu> {
	int save(Long roleId, Long menuId);

	int delete(Long roleId, Long menuId);

	List<SysMenu> findMenusByRoleIds(Set<Long> roleIds, String type);

	List<SysMenu> findMenusByRoleCodes(Set<String> roleCodes, String type);
}
