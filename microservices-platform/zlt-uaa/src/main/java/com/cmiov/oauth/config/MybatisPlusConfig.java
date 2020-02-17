package com.cmiov.oauth.config;

import com.cmiov.db.config.DefaultMybatisPlusConfig;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * @autho
 * @date 2018/12/10
 */
@Configuration
@MapperScan({"com.cmiov.oauth.mapper*"})
public class MybatisPlusConfig extends DefaultMybatisPlusConfig {

}
