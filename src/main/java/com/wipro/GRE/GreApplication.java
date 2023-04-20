package com.wipro.GRE;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "GRE Service"))
public class GreApplication {

	public static void main(String[] args) {
		SpringApplication.run(GreApplication.class, args);
	}

}
