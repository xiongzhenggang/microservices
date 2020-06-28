package com.xzg.framework.gateway.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;


/**
 * @autho
 * @date 2020/20/19
 */
@Component
@Data
@ConfigurationProperties(prefix = "security")
@RefreshScope //实现配置、实例热加载
public class SecurityProperties {
    private AuthProperties auth = new AuthProperties();

    private PermitProperties ignore = new PermitProperties();

//    private ValidateCodeProperties code = new ValidateCodeProperties();
}
