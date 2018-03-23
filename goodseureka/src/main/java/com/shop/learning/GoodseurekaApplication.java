package com.shop.learning;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class GoodseurekaApplication {

	public static void main(String[] args) {
		SpringApplication.run(GoodseurekaApplication.class, args);
	}
}
