package com.itmuch.cloud.study.user.feign;

import com.itmuch.cloud.study.config.UserFeignConfig;
import com.itmuch.cloud.study.user.entity.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @program: java-learn
 * @description:
 * @author: liquan
 * @create: 2020-05-15 16:46
 **/
@FeignClient(name = "microservice-provider-user", configuration = UserFeignConfig.class)
public interface UserFeignClient {
    @GetMapping("/users/{id}")
    User findById(@PathVariable("id") Long id);
}
