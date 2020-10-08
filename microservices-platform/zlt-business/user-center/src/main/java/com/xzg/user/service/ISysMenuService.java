package com.xzg.user.service;

import java.util.List;
import java.util.Set;

import com.xzg.common.model.SysMenu;
import com.xzg.common.service.ISuperService;

/**
 * @autho
 */
public interface ISysMenuService extends ISuperService<SysMenu> {
	/**
	 * 查询所有菜单
	 */
	List<SysMenu> findAll();

	/**
	 * 查询所有一级菜单
	 */
	List<SysMenu> findOnes();

	/**
	 * 角色分配菜单
	 * @param roleId
	 * @param menuIds
	 */
	void setMenuToRole(Long roleId, Set<Long> menuIds);

	/**
	 * 角色菜单列表
	 * @param roleIds 角色ids
	 * @return
	 */
	List<SysMenu> findByRoles(Set<Long> roleIds);

	/**
	 * 角色菜单列表
	 * @param roleIds 角色ids
	 * @param roleIds 是否菜单
	 * @return
	 */
	List<SysMenu> findByRoles(Set<Long> roleIds, String type);

	/**
	 * 角色菜单列表
	 * @param roleCodes
	 * @return
	 */
	List<SysMenu> findByRoleCodes(Set<String> roleCodes, String type);
}