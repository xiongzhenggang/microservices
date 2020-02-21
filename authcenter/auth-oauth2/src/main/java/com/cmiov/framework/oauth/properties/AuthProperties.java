package com.cmiov.framework.oauth.properties;

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
@ConfigurationProperties(prefix = "oauth2.token.renew")
@RefreshScope //实现配置、实例热加载
public class AuthProperties {
    boolean enable ;
    double timeRatio;
}
