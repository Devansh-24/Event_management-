package com.example;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
// @ComponentScan(basePackages= {"com.example.controller"+"com.example.service"})
public class UservalidationApplication {

	
	public static void main(String[] args) {
		SpringApplication.run(UservalidationApplication.class, args);
	System.out.println("hello");
	}

}
