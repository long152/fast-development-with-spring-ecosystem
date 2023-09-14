package com.example.fastdevelopment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class FastDevelopmentApplication {

	public static void main(String[] args) {
		SpringApplication.run(FastDevelopmentApplication.class, args);
	}

}
