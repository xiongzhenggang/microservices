package cmiov.user.service.impl;

import cmiov.user.mapper.SysRoleMenuMapper;
import cmiov.user.model.SysMenu;
import cmiov.user.model.SysRoleMenu;
import cmiov.user.service.ISysRoleMenuService;
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
@Service
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
