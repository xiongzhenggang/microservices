package com.xzg.framework.gateway.filter;

import com.xzg.framework.gateway.constant.CommonConstant;
import com.xzg.framework.auth.redis.constant.RedisToolsConstant;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.http.HttpMethod;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.security.config.web.server.SecurityWebFiltersOrder;
import org.springframework.security.oauth2.common.exceptions.InvalidTokenException;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.util.concurrent.TimeUnit;


//所有get、post请求添加序列号判断
@Slf4j
@Component
public class ResubmitHandleFilter implements GlobalFilter, Ordered {

    @Autowired
    RedisTemplate<String, Object> redisTemplate;

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        ServerHttpRequest request = exchange.getRequest();
        HttpMethod method = request.getMethod();
        //post\put\patch\delete据需要防止重复提交
        if(HttpMethod.GET.equals(method)){
            return chain.filter(exchange);
        }
        String sysSerialNum = request.getQueryParams().getFirst(CommonConstant.SYS_SERIAL_NUM);
        if(StringUtils.isEmpty(sysSerialNum)){
            new InvalidTokenException("request method (post、put、patch、delete) must have 'sysSerialNum'");
        }

        String redisKey = RedisToolsConstant.serialNumTempKey+sysSerialNum;

        String serialNumStore = (String)redisTemplate.opsForValue()
                .getAndSet(redisKey,CommonConstant.SYS_SERIAL_NUM);
        redisTemplate.expire(redisKey, CommonConstant.NUM_5, TimeUnit.MINUTES);

        if(CommonConstant.SYS_SERIAL_NUM.equals(sysSerialNum)||StringUtils.isEmpty(serialNumStore)){
            new InvalidTokenException("Serial number not found");
        }
        return chain.filter(exchange);
    }

    @Override
    public int getOrder() {
        return SecurityWebFiltersOrder.AUTHENTICATION.getOrder();
    }
}
