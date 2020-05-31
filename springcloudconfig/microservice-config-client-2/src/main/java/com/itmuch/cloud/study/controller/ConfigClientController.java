package com.itmuch.cloud.study.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConfigClientController {
//  @Value("${profile}")
//  private String profile;
//
//  @GetMapping("/profile")
//  public String hello() {
//    return this.profile;
//  }

  @Autowired
  private Environment env;

  @GetMapping("/from")
  public String hello() {
    return env.getProperty("from","undefine");
  }

}
