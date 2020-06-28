package com.xzg.framework.oauth.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;


/**
 * @autho
 * @date 2020/20/19
 */
@Data
@Component
@ConfigurationProperties(prefix = "security.code")
@RefreshScope //实现配置、实例热加载
public class ClientCodeProperties {
    private String[] ignoreClientCode = {};
}
