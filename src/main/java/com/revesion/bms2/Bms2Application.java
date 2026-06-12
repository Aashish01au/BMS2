package com.revesion.bms2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(description = "Employeee Rest Api" ,version = "5.2" , title = "API End Pont") )
public class Bms2Application {

	public static void main(String[] args) {
		SpringApplication.run(Bms2Application.class, args);
	}

}
