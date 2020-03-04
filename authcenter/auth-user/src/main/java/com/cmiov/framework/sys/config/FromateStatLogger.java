package com.cmiov.framework.sys.config;

import com.alibaba.druid.pool.DruidDataSourceStatLogger;
import com.alibaba.druid.pool.DruidDataSourceStatLoggerAdapter;
import com.alibaba.druid.pool.DruidDataSourceStatValue;
import com.alibaba.druid.stat.JdbcSqlStatValue;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.Map;

@Component
public class FromateStatLogger extends DruidDataSourceStatLoggerAdapter implements DruidDataSourceStatLogger {

    private static Logger logger = LoggerFactory.getLogger("druid");
    @Override
    public void log(DruidDataSourceStatValue statValue) {
        if (statValue.getSqlList().size() > 0) {
            for (JdbcSqlStatValue sqlStat : statValue.getSqlList()) {
                Map<String, Object> sqlStatMap = new LinkedHashMap<String, Object>();
                String sql = sqlStat.getSql();
                if(sql.contains("ping")){
                    return;
                }
                sql = sql.replace("\t", "");
                sql = sql.replace("\n", "");
                sqlStatMap.put("sql", sql);
                if (sqlStat.getExecuteCount() > 0) {
                    sqlStatMap.put("executeCount", sqlStat.getExecuteCount());
                    sqlStatMap.put("executeMillisMax", sqlStat.getExecuteMillisMax());
                    sqlStatMap.put("executeMillisTotal", sqlStat.getExecuteMillisTotal());
                    sqlStatMap.put("createTime", LocalDateTime.now());
                    sqlStatMap.put("systemName", "sql_log");
                }
                logger.warn(sqlStatMap.toString());
            }
        }
    }
}