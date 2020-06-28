package com.xzg.user.mapper;

import java.util.List;
import java.util.Set;

import com.xzg.db.mapper.SuperMapper;
import com.xzg.user.model.SysRoleMenu;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.xzg.common.model.SysMenu;

/**
 * @autho
 * 角色菜单
 */
@Mapper
public interface SysRoleMenuMapper extends SuperMapper<SysRoleMenu> {
	@Insert("insert into sys_role_menu_rel(role_id, menu_id) values(#{roleId}, #{menuId})")
	int save(@Param("roleId") Long roleId, @Param("menuId") Long menuId);

	int delete(@Param("roleId") Long roleId, @Param("menuId") Long menuId);

	List<SysMenu> findMenusByRoleIds(@Param("roleIds") Set<Long> roleIds, @Param("type") String type);

	List<SysMenu> findMenusByRoleCodes(@Param("roleCodes") Set<String> roleCodes, @Param("type") String type);
}
