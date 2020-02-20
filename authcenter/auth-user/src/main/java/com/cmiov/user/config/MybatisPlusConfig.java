package com.cmiov.user.config;

import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * @autho
 * @date 2018/12/10
 */
@Configuration
@MapperScan({"com.cmiov.user.mapper*"})
@Import(DateMetaObjectHandler.class)
public class MybatisPlusConfig {

    /**
     * 分页插件，自动识别数据库类型
     */
    @Bean
    public PaginationInterceptor paginationInterceptor() {
        PaginationInterceptor paginationInterceptor = new PaginationInterceptor();
//        boolean enableTenant = tenantProperties.getEnable();
//        //是否开启多租户隔离
//        if (enableTenant) {
//            TenantSqlParser tenantSqlParser = new TenantSqlParser()
//                    .setTenantHandler(tenantHandler);
//            paginationInterceptor.setSqlParserList(CollUtil.toList(tenantSqlParser));
//            paginationInterceptor.setSqlParserFilter(sqlParserFilter);
//        }
        return paginationInterceptor;
    }
}
