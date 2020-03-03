package com.cmiov.framework.gateway.web.api;


import reactor.core.publisher.Mono;

//网关web接口
public interface GatewayApi {


    //得到访问序列号
    public Mono<String> getSerialNum();

}
