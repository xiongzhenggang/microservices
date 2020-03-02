package com.cmiov.framework.gateway.feign.fallback;

import com.cmiov.framework.gateway.feign.MenuService;
import feign.hystrix.FallbackFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

/**
 * menuService降级工场
 *
 * @author
 * @date
 */
@Slf4j
@Component
public class MenuServiceFallbackFactory implements FallbackFactory<MenuService> {
    @Override
    public MenuService create(Throwable throwable) {
        return roleIds -> {
            log.error("调用findByRoleCodes异常：{}", roleIds, throwable);
            return new ArrayList<>();
        };
    }
}
