 package com.tyss.ApollingApp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.tyss")
public class ApollingAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApollingAppApplication.class, args);
	}

}
