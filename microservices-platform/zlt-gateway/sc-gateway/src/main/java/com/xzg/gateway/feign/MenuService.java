package com.xzg.gateway.feign;

import com.xzg.common.constant.ServiceNameConstants;
import com.xzg.common.model.SysMenu;
import com.xzg.gateway.feign.fallback.MenuServiceFallbackFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

/**
 * @author
 */
@FeignClient(name = ServiceNameConstants.USER_SERVICE, fallbackFactory = MenuServiceFallbackFactory.class, decode404 = true)
public interface MenuService {
	/**
	 * 角色菜单列表
	 * @param roleCodes
	 */
	@GetMapping(value = "/menus/{roleCodes}")
	List<SysMenu> findByRoleCodes(@PathVariable("roleCodes") String roleCodes);
}
