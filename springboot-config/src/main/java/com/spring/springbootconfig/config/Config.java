package com.spring.springbootconfig.config;

import com.spring.springbootconfig.bean.Group;
import com.spring.springbootconfig.bean.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {

    @Bean
    User user(){
        return new User();
    }

    @Bean
    Group group(){
        return new Group();
    }
}
