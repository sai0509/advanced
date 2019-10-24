package com.mortgage;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class MortgageUserserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(MortgageUserserviceApplication.class, args);
	}

}
