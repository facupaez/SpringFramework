package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class Exercise3Application {

	public static void main(String[] args) {

		ApplicationContext context = SpringApplication.run(Exercise3Application.class, args);
		UserRepository userRepository = context.getBean(UserRepository.class);

		// crear y almacenar usuario
		Users user = new Users("pepe3", "Pepe", "Torres", 15, "M. Irigoyen");
		Users user1 = new Users("arni", "Arnaldo", "Jones", 18, "M. Martin");
		userRepository.save(user);
		userRepository.save(user1);

		// buscar usuarios
		System.out.println(userRepository.findAll());

	}

}
