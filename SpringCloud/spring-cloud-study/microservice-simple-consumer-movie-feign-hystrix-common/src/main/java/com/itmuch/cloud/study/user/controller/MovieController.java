package com.itmuch.cloud.study.user.controller;

import com.itmuch.cloud.study.user.entity.User;
import com.itmuch.cloud.study.user.feign.UserFeignClient;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;


/**
 * @author linliquan
 */
@RequestMapping("/movies")
@RestController
public class MovieController {

    @Autowired
    private UserFeignClient userFeignClient;

    // 使用Hystrix服务降级
    @HystrixCommand(fallbackMethod = "findUserIdFallback")
    @GetMapping("/users/{id}")
    public User findUserId(@PathVariable Long id){
        return userFeignClient.findById(id);
    }

    public User findUserIdFallback(Long id){
        return new User(id,"默认用户","默认姓名",0,new BigDecimal(1));
    }
}
