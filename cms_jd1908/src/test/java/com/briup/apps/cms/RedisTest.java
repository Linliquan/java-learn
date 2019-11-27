package com.briup.apps.cms;

import com.briup.apps.cms.utils.RedisUtils;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
class RedisTest {

    @Resource
    private RedisUtils redisUtils;



    @Test
    void contextLoads() {
        redisUtils.set("101","小李子");
        System.out.println(redisUtils.get("101"));

    }

}
