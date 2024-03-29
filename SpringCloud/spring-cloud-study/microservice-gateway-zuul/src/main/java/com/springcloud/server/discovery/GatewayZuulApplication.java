package com.springcloud.server.discovery;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * @program: java-learn
 * @description: Zuul是Netflix开源的微服务网关,微服务网关是介于客户端和服务器端之间的中间层，
 * 所有的外部请求都会先经过微服务网关,减少了客户端与各个微服务之间的交互次数。
 * @author: liquan
 * @create: 2020-05-14 18:23
 **/
@EnableZuulProxy
@SpringBootApplication
public class GatewayZuulApplication {
    public static void main(String[] args) {
        SpringApplication.run(GatewayZuulApplication.class, args);
    }
}
