package com.example.demo.service.impl;

import com.example.demo.entity.UserEntity;
import com.example.demo.service.UserService;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class UserServiceImpl implements UserService {
    @Override
    public UserEntity findById(Long id) {
        if(id == null){
            throw new IllegalArgumentException("Valor id de usuario incorrecto, no es posible realizar la búsqueda.");
        }
        throw new NoSuchElementException("No se ha encontrado el usuario solicitado.");
    }
}
