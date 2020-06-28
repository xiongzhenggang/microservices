package com.xzg.framework.oauth.feign.fallback;

import com.xzg.framework.auth.redis.model.AppLoginUser;
import com.xzg.framework.auth.redis.model.SysUser;
import com.xzg.framework.oauth.feign.UserService;
import feign.hystrix.FallbackFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * userService降级工场
 *
 * @autho
 * @date 2019/1/18
 */
@Slf4j
@Component
public class UserServiceFallbackFactory implements FallbackFactory<UserService> {
    @Override
    public UserService create(Throwable throwable) {
        return new UserService() {
            @Override
            public SysUser selectByUsername(String username) {
                log.error("通过用户名查询用户异常:{}", username, throwable);
                return new SysUser();
            }

            @Override
            public AppLoginUser findByUsername(String username) {
                log.error("通过用户名查询用户异常:{}", username, throwable);
                return new AppLoginUser();
            }

            @Override
            public AppLoginUser findByMobile(String mobile) {
                log.error("通过手机号查询用户异常:{}", mobile, throwable);
                return new AppLoginUser();
            }

            @Override
            public AppLoginUser findByOpenId(String openId) {
                log.error("通过openId查询用户异常:{}", openId, throwable);
                return new AppLoginUser();
            }
        };
    }
}
