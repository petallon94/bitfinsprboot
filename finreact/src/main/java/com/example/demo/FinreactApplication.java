package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({"boot.shop.*","boot.react"})
public class FinreactApplication {

	public static void main(String[] args) {
		SpringApplication.run(FinreactApplication.class, args);
	}

}
