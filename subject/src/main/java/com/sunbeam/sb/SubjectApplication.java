package com.sunbeam.sb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

//@EnableEurekaClient
@EnableDiscoveryClient
@SpringBootApplication
public class SubjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(SubjectApplication.class, args);
	}

}
