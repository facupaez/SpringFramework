package com.example.demo.controllers;

import com.example.demo.entities.Laptop;
import com.example.demo.repositories.LaptopRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class LaptopController {

    LaptopRepository laptopRepository;
    private final Logger log = LoggerFactory.getLogger(LaptopController.class);

    public LaptopController(LaptopRepository laptopRepository){
        this.laptopRepository = laptopRepository;
    }

    /**
     * Buscar todos los objetos existentes de laptops en base de datos
     * http://localhost:8080/laptops
     * @return
     */
    @GetMapping("/laptops")
    public List<Laptop> findAll(){
        return laptopRepository.findAll();
    }

    /**
     * Buscar objeto laptop por id en base de datos
     * http://localhost:8080/laptops/1
     * @param id
     * @return
     */
    @GetMapping("/laptops/{id}")
    public ResponseEntity<Laptop> findById(@PathVariable Long id){
        Optional<Laptop> laptopOpt = laptopRepository.findById(id);
        if (!laptopOpt.isPresent()){
            log.warn("Sorry, this id doesn't exist");
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(laptopOpt.get());
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
        return ResponseEntity.ok(result);
    }


    /**
     * Actualizar objeto laptop en base de datos
     * http://localhost:8080/laptops
     * @param laptop
     * @return
     */
    @PutMapping("/laptops")
    public ResponseEntity<Laptop> update(@RequestBody Laptop laptop){
        if(laptop.getId() == null){
            log.warn("Trying to update a non existent laptop");
            return ResponseEntity.badRequest().build();
        }
        if (!laptopRepository.existsById(laptop.getId())){
            log.warn("Trying to update a non existent laptop");
            return ResponseEntity.notFound().build();
        }

        Laptop result = laptopRepository.save(laptop);
        return ResponseEntity.ok(result);
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
