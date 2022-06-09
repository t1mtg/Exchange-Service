package com.timotege;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class ExchangeServiceApplication {
	public static void main(String[] args) {
		SpringApplication.run(ExchangeServiceApplication.class, args);
	}

}

