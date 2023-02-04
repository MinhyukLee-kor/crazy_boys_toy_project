package com.example.crazyProject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.example.crazyProject.mapper")
public class CrazyProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrazyProjectApplication.class, args);
	}

}
