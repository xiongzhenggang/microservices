package com.cmiov.framework.gateway.web.service.impl;

import com.cmiov.framework.gateway.constant.CommonConstant;
import com.cmiov.framework.auth.redis.constant.RedisToolsConstant;
import com.cmiov.framework.gateway.web.service.GatewayService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.UUID;
import java.util.concurrent.TimeUnit;

@Slf4j
@Service
public class GatewayServiceImpl implements GatewayService {


    @Autowired
    RedisTemplate<String, Object> redisTemplate;

    @Override
    public String getSerialNum() {
        String uuid = UUID.randomUUID().toString();
        String redisKey = RedisToolsConstant.serialNumTempKey+uuid;
        redisTemplate.opsForValue().set(redisKey,uuid);
        redisTemplate.expire(redisKey, CommonConstant.NUM_5, TimeUnit.MINUTES);
        return uuid;
    }
}
