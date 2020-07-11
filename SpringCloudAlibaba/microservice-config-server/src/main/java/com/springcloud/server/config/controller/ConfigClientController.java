package com.springcloud.server.config.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: java-learn
 * @description:
 * @author: liquan
 * @create: 2020-07-11 21:12
 **/
@RestController
@RefreshScope
public class ConfigClientController {

    @Value("${profile}")
    private String profile;

    @GetMapping("/profile")
    public String hello() {
        return this.profile;
    }

}