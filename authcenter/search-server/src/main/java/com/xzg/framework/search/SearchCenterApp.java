package com.xzg.framework.search;

import com.xzg.framework.search.index.properties.IndexProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 *
 * @author xzg
 */
@EnableDiscoveryClient
@SpringBootApplication
@EnableConfigurationProperties(IndexProperties.class)
public class SearchCenterApp {
    public static void main(String[] args) {
        SpringApplication.run(SearchCenterApp.class, args);
    }
}
