package com.mukesh.accounts;

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.persistence.Column;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing(auditorAwareRef = "auditAwareImpl")
@OpenAPIDefinition(
		info = @Info(
				title = "Account microservices REST API Documentation",
				description = "EZBank Account microservices REST API Documentation",
				version = "v1",
				contact = @Contact(
						name = "Mukesh Anand",
						email = "mukeshanandmax@gmail.com",
						url = "https://www.linkedin.com/in/mukesh-anand----/"

				),
				license = @License(
						name = "Apache 3.5",
						url = "https://www.linkedin.com/in/mukesh-anand----/"
				)
		),externalDocs = @ExternalDocumentation(
				description = "EZBank Account microservices REST API Documentation",
				url = "https://www.linkedin.com/in/mukesh-anand----/"
		)
)
public class AccountsApplication {

	public static void main(String[] args) {
		SpringApplication.run(AccountsApplication.class, args);
	}

}
