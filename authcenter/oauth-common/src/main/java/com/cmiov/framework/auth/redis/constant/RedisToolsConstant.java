package com.cmiov.framework.auth.redis.constant;

/**
 * redis 工具常量
 */
public class RedisToolsConstant {
    private RedisToolsConstant() {
        throw new IllegalStateException("Utility class");
    }
    /**
     * single Redis
     */
    public final static int SINGLE = 1 ;

    /**
     * Redis cluster
     */
    public final static int CLUSTER = 2 ;


    //网关start   ----------
    public final static String serialNumTempKey = "gateway:temp:serialNum:";
    //网关end     ----------

}
