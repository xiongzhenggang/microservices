package com.cmiov;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

/** 
* @author
*/
@EnableDiscoveryClient
@EnableRedisHttpSession
@SpringBootApplication
public class AuthServerApp {
	public static void main(String[] args) {
		SpringApplication.run(AuthServerApp.class, args);
	}
}
