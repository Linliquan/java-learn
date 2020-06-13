package com.spring.study.springbootrabbitmqdirect;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
/**
 *  定时消息- 方式一：利用RabbitMQ 提供的死信队列实现 延迟队列
 */
public class SpringbootRabbitmqClusterConsumeApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootRabbitmqClusterConsumeApplication.class, args);
	}

}
