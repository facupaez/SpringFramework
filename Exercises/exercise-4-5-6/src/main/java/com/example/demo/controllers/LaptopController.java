package com.example.demo.controllers;

import com.example.demo.entities.Laptop;
import com.example.demo.exception.LaptopNotFoundException;
import com.example.demo.repositories.LaptopRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class LaptopController {

    @Autowired
    LaptopRepository laptopRepository;
    private final Logger log = LoggerFactory.getLogger(LaptopController.class);

    /**
     * Buscar todos los objetos existentes de laptops en base de datos
     * http://localhost:8080/laptops
     * @return
     */
    @GetMapping("/laptops")
    public ResponseEntity<Object> findAll(){
        List<Laptop> laptopList = laptopRepository.findAll();
        return new ResponseEntity<>(laptopList, HttpStatus.OK);
    }

    /**
     * Buscar objeto laptop por id en base de datos
     * http://localhost:8080/laptops/1
     * @param id
     * @return
     */
    @GetMapping("/laptops/{id}")
    public ResponseEntity<Object> findById(@PathVariable Long id){
        Optional<Laptop> optional = laptopRepository.findById(id);
        Laptop laptopOpt = optional.get();

        boolean isLaptopExists = laptopRepository.existsById(id);
        if (isLaptopExists){
            return new ResponseEntity<>(laptopOpt, HttpStatus.OK);
        }

        throw new LaptopNotFoundException();
    }

    /**
     * Crear objeto laptop en base de datos
     * http://localhost:8080/laptops
     * @param laptop
     * @return
     */
    @PostMapping("/laptops")
    public ResponseEntity<Laptop> create(@RequestBody Laptop laptop){
        if (laptop.getId() != null){
            log.warn("Trying to create a laptop with an existent id");
            return ResponseEntity.badRequest().build();
        }
        Laptop result = laptopRepository.save(laptop);
        System.out.println("Laptop created successfully!");
        return ResponseEntity.ok(result);
    }


    /**
     * Actualizar objeto laptop en base de datos
     * http://localhost:8080/laptops
     * @param laptop
     * @return
     */
    @PutMapping("/laptops/{id}")
    public ResponseEntity<Object> update(@PathVariable Long id, @RequestBody Laptop laptop){
        boolean isLaptopExists = laptopRepository.existsById(id);

        if (isLaptopExists){
            laptop.setId(id);
            Laptop result = laptopRepository.save(laptop);
            return ResponseEntity.ok(result);
        }

        return ResponseEntity.badRequest().build();
    }

    /**
     * Eliminar un objeto laptop por id de la base de datos
     * http://localhost:8080/laptops/1
     * @param id
     * @return
     */
    @DeleteMapping("/laptops/{id}")
    public ResponseEntity<Laptop> delete(@PathVariable Long id){
        if (!laptopRepository.existsById(id)){
            log.warn("Trying to delete a non existent laptop");
        }

        laptopRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    /**
     * Eliminar todos los objetos laptop de la base de datos (NO RECOMENDADO)
     * http://localhost:8080/laptops
     * @return
     */
    @DeleteMapping("/laptops")
    public ResponseEntity<Laptop> deleteAll(){
        log.info("REST Request for delete all laptops");
        laptopRepository.deleteAll();
        return ResponseEntity.noContent().build();
    }
}
