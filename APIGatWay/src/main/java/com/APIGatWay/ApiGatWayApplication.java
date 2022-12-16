package com.APIGatWay;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class ApiGatWayApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiGatWayApplication.class, args);
	}

}
