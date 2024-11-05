package com.back_end.JobsRocket;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
public class JobsRocketApplication {

	public static void main(String[] args) {
		SpringApplication.run(JobsRocketApplication.class, args);
	}

}
