package com.itmuch.cloud.study.user.feign;

import com.itmuch.cloud.study.config.UserFeignConfig;
import com.itmuch.cloud.study.user.entity.User;
import feign.hystrix.FallbackFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.math.BigDecimal;

/**
 * @program: java-learn
 * @description:
 * @author: liquan
 * @create: 2020-05-15 16:46
 **/
@FeignClient(name = "microservice-provider-user", configuration = UserFeignConfig.class, fallback = UserFeignClientFallback.class)
//@FeignClient(name = "microservice-provider-user", configuration = UserFeignConfig.class, fallbackFactory = UserFeignClientFallbackFactory.class)
public interface UserFeignClient {
    @GetMapping("/users/{id}")
    User findById(@PathVariable("id") Long id);
}


/**
 *  方式一：通过Fallback方式
 *  1.添加fallback = UserFeignClientFallback.class
 *  2.创建UserFeignClientFallback implements UserFeignClient
 */
@Component
class UserFeignClientFallback implements UserFeignClient {
    @Override
    public User findById(Long id) {
        return new User(id, "默认用户", "默认用户", 0, new BigDecimal(1));
    }
}

/**
 *  方式二：通过fallbackFactory ，获得造成fallback的原因
 *  1.添加fallback = UserFeignClientFallback.class
 *  2.创建UserFeignClientFallback implements UserFeignClient
 */
@Component
@Slf4j
class UserFeignClientFallbackFactory implements FallbackFactory<UserFeignClient> {
    @Override
    public UserFeignClient create(Throwable throwable) {
        return new UserFeignClient() {
            @Override
            public User findById(Long id) {
                log.error("进入回退逻辑", throwable);
                return new User(id, "默认用户", "默认用户", 0, new BigDecimal(1));
            }
        };
    }
}