package cmiov.gateway.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;

/**
 * @autho
 * @date 2019/1/4
 */
@Data
@ConfigurationProperties(prefix = "security")
@RefreshScope //实现配置、实例热加载
public class SecurityProperties {
    private AuthProperties auth = new AuthProperties();

    private PermitProperties ignore = new PermitProperties();

    private ValidateCodeProperties code = new ValidateCodeProperties();
}
