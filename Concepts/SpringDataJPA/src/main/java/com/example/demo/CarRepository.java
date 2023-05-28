package com.example.demo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/*
    Indicamos mediante la anotación @Repository que esta clase será un repositorio.
    Donde extenderemos de la clase JpaRepository y le pasaremos los parámetros nombre de clase y tipo de dato de ID.
 */
@Repository
public interface CarRepository extends JpaRepository<Car, Long> {
}
