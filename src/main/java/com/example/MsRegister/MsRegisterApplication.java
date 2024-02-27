package com.example.MsRegister;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
@EnableEurekaServer
@SpringBootApplication
public class MsRegisterApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsRegisterApplication.class, args);
	}
}
