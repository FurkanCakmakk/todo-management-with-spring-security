package com.cakmak.todov2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class TodoV2Application {

	public static void main(String[] args) {
		SpringApplication.run(TodoV2Application.class, args);
	}

}
