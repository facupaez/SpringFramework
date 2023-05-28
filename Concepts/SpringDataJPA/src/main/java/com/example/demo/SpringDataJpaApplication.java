package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SpringDataJpaApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(SpringDataJpaApplication.class, args);
		CarRepository carRepository = context.getBean(CarRepository.class);


		// crear y almacenar car en base de datos
		Car toyota = new Car("Toyota", "Azul", 2023);
		carRepository.save(toyota);

		// recuperar car por id
		System.out.println("Buscando auto..." + carRepository.findAll());
	}

}
