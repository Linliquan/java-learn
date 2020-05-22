package com.springcloud.server.discovery;

import com.springcloud.server.discovery.filter.PreRequestLogFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;


/**
 * @program: java-learn
 * @description: 通过zuul网关调用微服务前设置拦截，比如权限验证等
 * @author: liquan
 * @create: 2020-05-14 18:23
 **/
@EnableZuulProxy
@SpringBootApplication
public class GatewayZuulFilterApplication {
    public static void main(String[] args) {
        SpringApplication.run(GatewayZuulFilterApplication.class, args);
    }

//    @Bean
//    public PreRequestLogFilter preRequestLogFilter() {
//        return new PreRequestLogFilter();
//    }
}
