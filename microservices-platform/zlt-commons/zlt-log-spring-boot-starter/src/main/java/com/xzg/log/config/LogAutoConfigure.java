package com.xzg.log.config;

import com.xzg.log.properties.AuditLogProperties;
import com.xzg.log.properties.TraceProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

/**
 * 日志自动配置
 *
 * @author
 * @date 2019/8/13
 */
@EnableConfigurationProperties({TraceProperties.class, AuditLogProperties.class})
public class LogAutoConfigure {

}
