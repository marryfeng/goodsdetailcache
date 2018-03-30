package com.shop.learning;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.turbine.EnableTurbine;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableEurekaClient
@ComponentScan
@EnableTurbine
public class TurbineServiceApplication {

	public static void main(String[] args) {

		SpringApplication.run(TurbineServiceApplication.class, args);
	}
}
