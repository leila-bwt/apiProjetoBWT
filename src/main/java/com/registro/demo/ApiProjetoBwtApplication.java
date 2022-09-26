package com.registro.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EntityScan(basePackages = {"com.registro.modelDOMEN"})
@ComponentScan(basePackages = {"com.registro.controller", "com.registro.demo", "com.registro.exception", "com.registro.model.enums", "com.registro.repositories", "com.registro.services", "com.registro.service.excpetion", "com.registro.services.impl"})
public class ApiProjetoBwtApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiProjetoBwtApplication.class, args);
	}

}
