package com.itmuch.cloud.study.config;


import feign.Logger;
import org.springframework.context.annotation.Bean;


/**
 * @program: java-learn
 * @description: Feign配置自定义【细粒度配置】-为Feign开启日志
 * @author: liquan
 * @create: 2020-05-15 17:47
 **/
public class UserFeignConfig {

    /**
     * 该Feign Client的配置类，注意：
     * 1. 该类可以独立出去；
     * 2. 该类上也可添加@Configuration声明是一个配置类；
     * 配置类上也可添加@Configuration注解，声明这是一个配置类；
     * 但此时千万别将该放置在主应用程序上下文@ComponentScan所扫描的包中，
     * 否则，该配置将会被所有Feign Client共享，无法实现细粒度配置！
     * 个人建议：像我一样，不加@Configuration注解
     *
     * @author linliquan
     */
    @Bean
    public Logger.Level logger() {

        /**
         * 1.NONE【性能最佳，适用于生产】：不记录任何日志（默认值）。
         * 2.BASIC【适用于生产环境追踪问题】：仅记录请求方法、URL、响应状态代码以及执行时间。
         * 3.HEADERS：记录BASIC级别的基础上，记录请求和响应的header。
         * 4.FULL【比较适用于开发及测试环境定位问题】：记录请求和响应的header、body和元数据。
         */
        return Logger.Level.FULL;
    }
}
