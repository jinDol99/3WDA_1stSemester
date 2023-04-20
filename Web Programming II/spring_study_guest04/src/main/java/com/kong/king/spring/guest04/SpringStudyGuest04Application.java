package com.kong.king.spring.guest04;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class SpringStudyGuest04Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringStudyGuest04Application.class, args);
	}

}
