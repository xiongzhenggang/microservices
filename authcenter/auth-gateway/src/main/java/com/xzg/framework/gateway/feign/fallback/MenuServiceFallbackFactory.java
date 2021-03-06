package com.xzg.framework.gateway.feign.fallback;

import com.xzg.framework.gateway.model.SysMenu;
import com.xzg.framework.gateway.feign.MenuService;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

/**
 * menuService降级工场
 *
 * @author
 * @date
 */
@Slf4j
public class  MenuServiceFallbackFactory implements MenuService {

    @Override
    public List<SysMenu> findByRoleCodes(String roleCodes) {
        log.error("调用findByRoleCodes异常：{}", roleCodes);
        return new ArrayList<>();
    }

    @Override
    public List<SysMenu> findAlls() {
        log.error("调用findAlls异常");
        return new ArrayList<>();
    }
}
