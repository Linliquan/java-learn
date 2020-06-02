package com.itmuch.cloud.study;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

//@EnableDiscoveryClient
@SpringBootApplication
public class ConfigClient2Application {
  public static void main(String[] args) {
    SpringApplication.run(ConfigClient2Application.class, args);
  }
}
