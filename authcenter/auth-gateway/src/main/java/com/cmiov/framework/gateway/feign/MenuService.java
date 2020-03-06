package com.cmiov.framework.gateway.feign;

import com.cmiov.framework.gateway.feign.fallback.MenuServiceFallbackFactory;
import com.cmiov.framework.gateway.model.SysMenu;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * @author
 */
@FeignClient(name = "${application.user.service}", fallback = MenuServiceFallbackFactory.class)
public interface MenuService {
	/**
	 * 角色菜单列表
	 * @param roleCodes
	 */
	@Cacheable(value = "role_menu", key ="#roleCodes")
	@RequestMapping(method = RequestMethod.GET, value = "/menus/{roleCodes}")
    List<SysMenu> findByRoleCodes(@PathVariable("roleCodes") String roleCodes);

	/**
	 * 所有菜单列表
	 */
	@Cacheable(value = "all_menu")
	@RequestMapping(method = RequestMethod.GET, value = "/menus/findAlls")
	List<SysMenu> findAlls();


}
