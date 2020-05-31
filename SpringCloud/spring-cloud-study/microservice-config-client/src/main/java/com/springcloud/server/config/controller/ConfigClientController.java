package com.springcloud.server.config.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: java-learn
 * @description:
 * @author: liquan
 * @create: 2020-05-22 19:59
 **/
@RefreshScope
@RestController
public class ConfigClientController {
//    @Value("${from}")
//    private String from;
    @Autowired
    private Environment env;

    @GetMapping("/from")
    public String hello() {
        return env.getProperty("from","undefine");
//        return this.from;
    }
}
