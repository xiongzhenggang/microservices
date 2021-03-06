package com.xzg.framework.gateway.auth.config;

import com.xzg.framework.gateway.auth.handler.JsonAccessDeniedHandler;
import com.xzg.framework.gateway.auth.CustomAuthenticationManager;
import com.xzg.framework.gateway.auth.JsonAuthenticationEntryPoint;
import com.xzg.framework.gateway.auth.PermissionAuthManager;
import com.xzg.framework.gateway.auth.handler.Oauth2AuthSuccessHandler;
import com.xzg.framework.gateway.properties.SecurityProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.ReactiveAuthenticationManager;
import org.springframework.security.config.web.server.SecurityWebFiltersOrder;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.server.resource.web.server.ServerBearerTokenAuthenticationConverter;
import org.springframework.security.web.server.SecurityWebFilterChain;
import org.springframework.security.web.server.authentication.AuthenticationWebFilter;
import org.springframework.security.web.server.authentication.ServerAuthenticationEntryPointFailureHandler;

/**
 * 资源服务器配置
 *
 * @author
 * @date
 * <p>
 */
@Configuration
public class ResourceServerConfiguration {
    @Autowired
    private SecurityProperties securityProperties;

    @Autowired
    private TokenStore tokenStore;

    @Autowired
    private PermissionAuthManager permissionAuthManager;

    /**
     * This bean is responsible for all the security (protecting the application URLs, validating submitted username and passwords,
     * redirecting to the log in form, and so on) within your application
     * @param http
     * @return
     */
    @Bean
    SecurityWebFilterChain springSecurityFilterChain(ServerHttpSecurity http) {
        //认证处理器
        ReactiveAuthenticationManager customAuthenticationManager = new CustomAuthenticationManager(tokenStore);
        JsonAuthenticationEntryPoint entryPoint = new JsonAuthenticationEntryPoint();
        //token转换器
        ServerBearerTokenAuthenticationConverter tokenAuthenticationConverter = new ServerBearerTokenAuthenticationConverter();
        tokenAuthenticationConverter.setAllowUriQueryParameter(true);
        //oauth2认证过滤器
        AuthenticationWebFilter oauth2Filter = new AuthenticationWebFilter(customAuthenticationManager);
        oauth2Filter.setServerAuthenticationConverter(tokenAuthenticationConverter);
        oauth2Filter.setAuthenticationFailureHandler(new ServerAuthenticationEntryPointFailureHandler(entryPoint));
        oauth2Filter.setAuthenticationSuccessHandler(new Oauth2AuthSuccessHandler());
        http.addFilterAt(oauth2Filter, SecurityWebFiltersOrder.AUTHENTICATION);

        ServerHttpSecurity.AuthorizeExchangeSpec authorizeExchange = http.authorizeExchange();
        if (securityProperties.getAuth().getHttpUrls().length > 0) {
            authorizeExchange.pathMatchers(securityProperties.getAuth().getHttpUrls()).authenticated();
        }
        if (securityProperties.getIgnore().getUrls().length > 0) {
            authorizeExchange.pathMatchers(securityProperties.getIgnore().getUrls()).permitAll();
        }
        authorizeExchange
                .pathMatchers(HttpMethod.OPTIONS).permitAll()
                .anyExchange()
                    .access(permissionAuthManager)
                .and()
                    .exceptionHandling()
                        .accessDeniedHandler(new JsonAccessDeniedHandler())
                        .authenticationEntryPoint(entryPoint)
                .and()
                    .headers()
                        .frameOptions()
                        .disable()
                .and()
                    .httpBasic().disable()
                    .csrf().disable();
        return http.build();
    }
}
