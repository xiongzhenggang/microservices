package com.cmiov.framework.auth.redis.util;

import com.alibaba.fastjson.JSON;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.SerializationException;

import java.nio.charset.Charset;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author xzg
 */
public class FastJson2JsonRedisSerializer<T,E> implements RedisSerializer<T> {

    private static final Charset DEFAULT_CHARSET = Charset.forName("UTF-8");

    private static final Set<Class> supportCollectionClass = new HashSet<>();

    static{
        supportCollectionClass.add(List.class);
        supportCollectionClass.add(Set.class);
    }

    private Class<T> fistClass;
    private Class<E> memberClass;

    public FastJson2JsonRedisSerializer(Class<T> fistClass){
        this.fistClass = fistClass;
    }

    /**
     * Just support List.class or Set.class
     * @param fistClass List.class or Set.class
     * @param memberClass
     */
    public FastJson2JsonRedisSerializer(Class<T> fistClass, Class<E> memberClass){
        if(supportCollectionClass.contains(fistClass)){
            this.fistClass = fistClass;
            this.memberClass = memberClass;
        }else{
            throw new RuntimeException("Just support List.class or Set.class");
        }
    }

    @Override
    public byte[] serialize(T t) throws SerializationException {
        if (t == null) {
            return new byte[0];
        }

//        return JSON.toJSONString(t, SerializerFeature.WriteClassName).getBytes(DEFAULT_CHARSET);
        return JSON.toJSONString(t).getBytes(DEFAULT_CHARSET);
    }

    @Override
    public T deserialize(byte[] bytes) throws SerializationException {
        if(null == bytes || bytes.length <= 0){
            return null;
        }
        String str = new String(bytes, DEFAULT_CHARSET);
        if(List.class.isAssignableFrom(fistClass)){
            List<E> list = JSON.parseArray(str, memberClass);
            return (T)list;
        }
        if(Set.class.isAssignableFrom(fistClass)){
            List<E> list = JSON.parseArray(str, memberClass);
            Set set = new HashSet(list);
            return (T)set;
        }
        return JSON.parseObject(str, fistClass);
    }

}