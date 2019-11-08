package com.spring.springbootconfig;

import com.spring.springbootconfig.bean.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;



@SpringBootTest
class SpringbootConfigApplicationTests {

    @Autowired
    User  user;

    @Test
    void contextLoads() {
        System.out.println(user);
        System.out.println(user.getGroup());
    }

}
