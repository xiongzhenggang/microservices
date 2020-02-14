package com.cmiov.user.config;

import com.cmiov.db.config.DefaultMybatisPlusConfig;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * @autho
 * @date 2018/12/10
 */
@Configuration
@MapperScan({"com.central.user.mapper*"})
public class MybatisPlusConfig extends DefaultMybatisPlusConfig {
}
