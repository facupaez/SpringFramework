package com.example.demo;

import com.example.demo.entities.Laptop;
import com.example.demo.repositories.LaptopRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class Exercise456Application {

	public static void main(String[] args) {

		ApplicationContext context = SpringApplication.run(Exercise456Application.class, args);
		LaptopRepository repository = context.getBean(LaptopRepository.class);

		Laptop laptop = new Laptop(null, "Windows 10", "black", 15.6, 1, 16, "i7", true);
		Laptop laptop2 = new Laptop(null, "Windows 8", "gray", 14.0, 512, 8, "i3", false);

		repository.save(laptop);
		repository.save(laptop2);
	}

}
