package com.xzg.user.config;

import com.xzg.db.config.DefaultMybatisPlusConfig;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * @autho
 * @date 2018/12/10
 */
@Configuration
@MapperScan({"com.xzg.user.mapper*"})
public class MybatisPlusConfig extends DefaultMybatisPlusConfig {
}
