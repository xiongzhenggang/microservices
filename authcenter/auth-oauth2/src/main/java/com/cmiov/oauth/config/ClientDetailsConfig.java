//package com.cmiov.oauth.config;
//
//import com.cmiov.oauth.service.impl.RedisAuthorizationCodeServices;
//import com.cmiov.oauth.service.impl.RedisClientDetailsService;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.data.redis.core.RedisTemplate;
//import org.springframework.security.oauth2.provider.code.RandomValueAuthorizationCodeServices;
//
//import javax.annotation.Resource;
//import javax.sql.DataSource;
//
///**
// * @autho
// * @date
// */
//@Configuration
//public class ClientDetailsConfig {
//    @Resource
//    private DataSource dataSource;
//    @Resource
//    private RedisTemplate<String, Object> redisTemplate;
//
//    /**
//     * 声明 ClientDetails实现
//     */
//    @Bean
//    public RedisClientDetailsService clientDetailsService() {
//        RedisClientDetailsService clientDetailsService = new RedisClientDetailsService(dataSource);
//        clientDetailsService.setRedisTemplate(redisTemplate);
//        return clientDetailsService;
//    }
//
//    @Bean
//    public RandomValueAuthorizationCodeServices authorizationCodeServices() {
//        RedisAuthorizationCodeServices redisAuthorizationCodeServices = new RedisAuthorizationCodeServices();
//        redisAuthorizationCodeServices.setRedisTemplate(redisTemplate);
//        return redisAuthorizationCodeServices;
//    }
//}
