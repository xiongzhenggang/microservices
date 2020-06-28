package com.xzg;

import com.xzg.common.ribbon.annotation.EnableBaseFeignInterceptor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author
 * @date 2019/10/5
 * <p>
 */
@EnableFeignClients
@EnableBaseFeignInterceptor
@EnableDiscoveryClient
@SpringBootApplication
public class SCGatewayApp {
    public static void main(String[] args) {
        SpringApplication.run(SCGatewayApp.class, args);
    }
}