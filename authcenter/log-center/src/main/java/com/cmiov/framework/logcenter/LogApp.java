package com.cmiov.framework.logcenter;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @autho
 */
@EnableDiscoveryClient
@SpringBootApplication
@MapperScan({"com.cmiov.framework.logcenter.mapper*"})
public class LogApp {
	public static void main(String[] args) {
		SpringApplication.run(LogApp.class, args);
	}
}
