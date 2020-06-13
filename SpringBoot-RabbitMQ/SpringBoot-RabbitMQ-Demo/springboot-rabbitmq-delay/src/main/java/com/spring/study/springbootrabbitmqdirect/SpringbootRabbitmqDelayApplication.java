package com.spring.study.springbootrabbitmqdirect;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync // 开启异步
/**
 *  定时消息- 方式一：利用RabbitMQ 提供的死信队列实现 延迟队列
 */
public class SpringbootRabbitmqDelayApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootRabbitmqDelayApplication.class, args);
	}

}
