package com.cmiov.framework.gateway.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class WebclientConfig {
    @Bean
    @LoadBalanced//集群支持，负载均衡，必须要有本注解，不然请求会失败
    public WebClient.Builder webClientBuilder(){
        return WebClient.builder();
    }

}
