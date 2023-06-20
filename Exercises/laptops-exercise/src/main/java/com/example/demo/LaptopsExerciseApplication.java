package com.example.demo;

import com.example.demo.entities.Laptop;
import com.example.demo.repositories.LaptopRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class LaptopsExerciseApplication {

	public static void main(String[] args) {

		ApplicationContext context = SpringApplication.run(LaptopsExerciseApplication.class, args);
		LaptopRepository repository = context.getBean(LaptopRepository.class);

		Laptop laptop = new Laptop("Windows 10", "black", 15.6, 1, 16, "i7", true);
		Laptop laptop2 = new Laptop("Windows 8", "gray", 14.0, 512, 8, "i3", false);

		repository.save(laptop);
		repository.save(laptop2);
	}

}
