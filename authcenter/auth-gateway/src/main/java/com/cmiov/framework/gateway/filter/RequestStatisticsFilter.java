package com.cmiov.framework.gateway.filter;

import com.cmiov.framework.gateway.constant.SecurityConstants;
import com.cmiov.framework.gateway.model.AuditLogDto;
import com.cmiov.framework.gateway.model.Result;
import com.cmiov.framework.gateway.utils.IPAddrUtil;
import com.sun.xml.internal.ws.api.message.Header;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.HttpMethod;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.util.Map;

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

    @Value("${application.log.service}")
    private String logService;

    @Autowired
    private WebClient.Builder clientBuilder;

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        ServerHttpRequest request = exchange.getRequest();
        Map<String, String> headers = request.getHeaders().toSingleValueMap();
//        UserAgent userAgent = UserAgent.parseUserAgentString(headers.get("User-Agent"));
        //埋点
//        PointUtil.debug("1", "request-statistics",
//                "ip=" + ReactiveAddrUtil.getRemoteAddr(request)
//                        + "&browser=" + userAgent.getBrowser()
//                        + "&operatingSystem=" + userAgent.getOperatingSystem());
        AuditLogDto dto = new AuditLogDto();
        dto.setIpAddress(IPAddrUtil.getRemoteAddr(request));
        dto.setUserId(Integer.valueOf(headers.get(SecurityConstants.USER_ID_HEADER)));
        dto.setUserName(headers.get(SecurityConstants.USER_HEADER));
        dto.setMethondType(request.getMethodValue());
        dto.setResourceUrl(request.getURI().getPath());
        clientBuilder
                .baseUrl("http://"+logService+"/auditlog")
                .build()
                .method(HttpMethod.POST)
                .body(Mono.just(dto),AuditLogDto.class)
                .retrieve()//请求结果的方法
                .bodyToMono(Result.class)
                .doOnError(e -> {
                    log.error(e.getMessage());
                });
        return chain.filter(exchange);
    }

    @Override
    public int getOrder() {
        return 0;
    }
}
