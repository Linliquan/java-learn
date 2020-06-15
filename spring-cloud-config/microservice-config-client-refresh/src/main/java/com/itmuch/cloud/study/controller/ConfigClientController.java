package com.itmuch.cloud.study.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 配置刷新三要素 : 3.待刷新的配置属性所在的类上添加了@RefreshScope注解
 * 这样，修改profile 配置后，只需向应用的/actuator/refresh 端点发送POST请求，即可刷新该属性。
 * 例如：curl -X POST http://localhost:8082/actuator/refresh
 */
@RefreshScope
@RestController
public class ConfigClientController {
//  @Value("${from}")
//  private String profile;
//
//  @GetMapping("/from")
//  public String hello() {
//    return this.from;
//  }

  @Autowired
  private Environment env;

  @GetMapping("/from")
  public String hello() {
    return env.getProperty("from","undefine");
  }

}
