package com.xzg.framework.sys.config;

import com.alibaba.druid.filter.Filter;
import com.alibaba.druid.filter.logging.Slf4jLogFilter;
import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

@Configuration
public class DuridSqlConfig {

    @Autowired
    private FromateStatLogger fromateStatLogger;
    @Bean
    public Slf4jLogFilter logFilter(){
        Slf4jLogFilter filter = new Slf4jLogFilter();
        filter.setResultSetLogEnabled(false);
        filter.setConnectionLogEnabled(false);
        filter.setStatementParameterClearLogEnable(false);
        filter.setStatementCreateAfterLogEnabled(false);
        filter.setStatementCloseAfterLogEnabled(false);
        filter.setStatementParameterSetLogEnabled(false);
        filter.setStatementPrepareAfterLogEnabled(false);
        return  filter;
    }
    @Primary
    @Bean
    @ConfigurationProperties("spring.datasource.druid")
    public DataSource dataSourceOne(){
        DruidDataSource druidDataSource =  DruidDataSourceBuilder.create().build();
        List<Filter> list= new ArrayList<Filter>(){{add(logFilter());}};
        druidDataSource.setProxyFilters(list);
        //定期发送道日志
        druidDataSource.setTimeBetweenLogStatsMillis(3000);
        druidDataSource.setStatLogger(fromateStatLogger);
        return druidDataSource;
    }

}
