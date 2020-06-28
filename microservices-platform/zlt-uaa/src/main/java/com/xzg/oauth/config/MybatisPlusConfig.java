package com.xzg.oauth.config;

import com.xzg.db.config.DefaultMybatisPlusConfig;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * @autho
 * @date 2018/12/10
 */
@Configuration
@MapperScan({"com.xzg.oauth.mapper*"})
public class MybatisPlusConfig extends DefaultMybatisPlusConfig {

}
