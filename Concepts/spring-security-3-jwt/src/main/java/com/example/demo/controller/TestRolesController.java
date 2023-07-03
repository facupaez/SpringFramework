package com.example.demo.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestRolesController {

    @GetMapping("/accessAdmin")
    @PreAuthorize("hasRole('ADMIN')")
    public String accessAdmin() {
        return "Has accedido con el rol de ADMINISTRADOR";
    }

    @GetMapping("/accessUser")
    @PreAuthorize("hasRole('USER')")
    public String accessUser() {
        return "Has accedido con el rol de USUARIO";
    }

    @GetMapping("/accessGuest")
    @PreAuthorize("hasRole('GUEST')")
    public String accessGuest() {
        return "Has accedido con el rol de INVITADO";
    }
}
