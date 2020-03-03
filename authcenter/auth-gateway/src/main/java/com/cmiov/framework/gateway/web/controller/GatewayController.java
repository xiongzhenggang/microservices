package com.cmiov.framework.gateway.web.controller;

import com.cmiov.framework.gateway.web.api.GatewayApi;
import com.cmiov.framework.gateway.web.service.GatewayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/gateway")
public class GatewayController implements GatewayApi {

    @Autowired
    GatewayService gatewayService;

    @Override
    @GetMapping("/serialNum")
    public Mono<String> getSerialNum() {
        return Mono.just(gatewayService.getSerialNum());
    }
}
