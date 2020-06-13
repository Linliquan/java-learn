package com.spring.study.springbootrabbitmqdirect;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync // 开启异步
/**
 *  消费重试
 */
public class SpringbootRabbitmqBatchConsumeRetryApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootRabbitmqBatchConsumeRetryApplication.class, args);
	}

}
