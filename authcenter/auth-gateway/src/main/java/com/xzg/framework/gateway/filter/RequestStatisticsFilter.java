package com.xzg.framework.gateway.filter;

import com.xzg.framework.gateway.service.LogService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;


/**
 * 请求统计分析埋点过滤器
 *
 * @author
 * @date
 * <p>
 */
@Slf4j
@Component
public class RequestStatisticsFilter implements GlobalFilter, Ordered {

    @Autowired
    private LogService logService;

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        ServerHttpRequest request = exchange.getRequest();
        logService.sendAuditLog(request);
        return chain.filter(exchange);
    }

    @Override
    public int getOrder() {
        return 0;
    }
}
