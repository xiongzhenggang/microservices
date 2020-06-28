package com.xzg.framework.gateway.auth.handler;

import com.xzg.framework.gateway.constant.SecurityConstants;
import com.xzg.framework.gateway.utils.StringCollectionUtil;
import com.xzg.framework.auth.redis.model.SysUser;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.server.WebFilterExchange;
import org.springframework.security.web.server.authentication.ServerAuthenticationSuccessHandler;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

/**
 * 认证成功处理类
 *
 * @author
 * @date 2020/2/19
 * <p>
 */
public class Oauth2AuthSuccessHandler implements ServerAuthenticationSuccessHandler {
    @Override
    public Mono<Void> onAuthenticationSuccess(WebFilterExchange webFilterExchange, Authentication authentication) {
        MultiValueMap<String, String> headerValues = new LinkedMultiValueMap(4);
        Object principal = authentication.getPrincipal();
        //客户端模式只返回一个clientId
        if (principal instanceof SysUser) {
            SysUser user = (SysUser)authentication.getPrincipal();
            headerValues.add(SecurityConstants.USER_ID_HEADER, String.valueOf(user.getId()));
            headerValues.add(SecurityConstants.USER_HEADER, user.getUserName());
            headerValues.add(SecurityConstants.ORG_ID_HEADER, String.valueOf(user.getOrgId()));
        }
//        OAuth2Authentication oauth2Authentication = (OAuth2Authentication)authentication;
//        String clientId = oauth2Authentication.getOAuth2Request().getClientId();
//        headerValues.add(SecurityConstants.TENANT_HEADER, clientId);

        headerValues.add(SecurityConstants.ROLE_HEADER, StringCollectionUtil.join(authentication.getAuthorities(), ","));

        ServerWebExchange exchange = webFilterExchange.getExchange();
        ServerHttpRequest serverHttpRequest = exchange.getRequest().mutate()
                .headers(h -> {
                    h.addAll(headerValues);
                })
                .build();

        ServerWebExchange build = exchange.mutate().request(serverHttpRequest).build();
        return webFilterExchange.getChain().filter(build);
    }
}
