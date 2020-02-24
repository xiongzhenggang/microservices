package com.cmiov.framework.sys.annotation;

import java.lang.annotation.*;

/**
 * @author xzg
 * 请求的方法参数SysUser上添加该注解，注入当前登录人信息
 * (@LoginUser SysUser user)
 */
@Target(ElementType.PARAMETER)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface LoginUserInfo {
    /**
     * 是否查询SysUser对象所有信息，true则通过rpc接口查询
     */
    boolean isFull() default false;
}
