package com.itmuch.cloud.study.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConfigClientController {

  @Value("${from}")
  private String from;

  @GetMapping("/from")
  public String hello() {
    return this.from;
  }

}
