package com.example.rockpaperscissors;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@OpenAPIDefinition(
		info = @Info(
				title = "Rock-Paper-Scissors Game",
				version = "1",
				description = "Test project",
				contact = @Contact(name = "Nataliia", email = "nataliia.mirosh@hmail.com")
		)
)
@SpringBootApplication
public class RockPaperScissorsApplication {

	public static void main(String[] args) {
		SpringApplication.run(RockPaperScissorsApplication.class, args);
	}

}
