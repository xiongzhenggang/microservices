package cmiov.gateway.feign;

import cmiov.gateway.feign.fallback.MenuServiceFallbackFactory;
import cmiov.gateway.model.SysMenu;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

/**
 * @author
 */
@FeignClient(name = "user-center", fallbackFactory = MenuServiceFallbackFactory.class, decode404 = true)
public interface MenuService {
	/**
	 * 角色菜单列表
	 * @param roleCodes
	 */
	@GetMapping(value = "/menus/{roleCodes}")
    List<SysMenu> findByRoleCodes(@PathVariable("roleCodes") String roleCodes);
}
