package com.xzg.framework.sys.config;

import com.xzg.framework.sys.user.service.ISysUserService;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.annotation.Resource;
import java.util.List;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Resource
    private ISysUserService userService;
    /**
     * 配置外部HandlerMethodArgumentResolver
     */
    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> argumentResolvers) {
        argumentResolvers.add(new UserArgumentResolver(userService));
    }

}