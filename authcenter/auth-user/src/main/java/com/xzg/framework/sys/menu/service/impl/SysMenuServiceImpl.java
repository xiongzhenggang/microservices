package com.xzg.framework.sys.menu.service.impl;

import com.xzg.framework.sys.role.entity.SysRoleMenu;
import com.xzg.framework.sys.role.service.ISysRoleMenuService;
import com.xzg.framework.sys.menu.service.ISysMenuService;
import com.xzg.framework.sys.menu.mapper.SysMenuMapper;
import com.xzg.framework.sys.menu.entity.SysMenu;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * @author
 */
@Slf4j
@Service
public class SysMenuServiceImpl extends ServiceImpl<SysMenuMapper, SysMenu> implements ISysMenuService {
 	@Autowired
	private ISysRoleMenuService roleMenuService;

 	@Autowired
	private SysMenuMapper sysMenuMapper;
	@Transactional(rollbackFor = Exception.class)
	@Override
	public void setMenuToRole(Long roleId, Set<Long> menuIds) {
		roleMenuService.delete(roleId, null);

		if (!CollectionUtils.isEmpty(menuIds)) {
			List<SysRoleMenu> roleMenus = new ArrayList<>(menuIds.size());
			menuIds.forEach(menuId -> roleMenus.add(new SysRoleMenu(roleId, menuId)));
			roleMenuService.saveBatch(roleMenus);
		}
	}

	/**
	 * 角色菜单列表
	 * @param roleIds
	 * @return
	 */
	@Override
	public List<SysMenu> findByRoles(Set<Long> roleIds) {
		return roleMenuService.findMenusByRoleIds(roleIds, null);
	}

	/**
	 * 角色菜单列表
	 * @param roleIds 角色ids
	 * @param roleIds 是否菜单
	 * @return
	 */
	@Override
	public List<SysMenu> findByRoles(Set<Long> roleIds, String type) {
		return roleMenuService.findMenusByRoleIds(roleIds, type);
	}

	@Override
	public List<SysMenu> findByRoleCodes(Set<String> roleCodes, String type) {
		return roleMenuService.findMenusByRoleCodes(roleCodes, type);
	}

    /**
     * 查询所有菜单
     */
	@Override
	public List<SysMenu> findAll() {
		return sysMenuMapper.findAll();
//		return baseMapper.selectList(
//                new QueryWrapper<SysMenu>().orderByAsc("sort")
//        );
	}

    /**
     * 查询所有一级菜单
     */
	@Override
	public List<SysMenu> findOnes() {
        return baseMapper.selectList(
                new QueryWrapper<SysMenu>()
                        .eq("type", 1)
                        .orderByAsc("sort")
        );
	}
}
