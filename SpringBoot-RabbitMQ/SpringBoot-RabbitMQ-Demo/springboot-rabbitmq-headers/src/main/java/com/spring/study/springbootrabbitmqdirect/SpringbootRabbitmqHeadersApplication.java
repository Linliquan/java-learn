package com.spring.study.springbootrabbitmqdirect;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync // 开启异步
public class SpringbootRabbitmqHeadersApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootRabbitmqHeadersApplication.class, args);
	}

}
