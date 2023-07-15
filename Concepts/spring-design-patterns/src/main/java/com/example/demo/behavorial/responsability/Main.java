package com.example.demo.behavorial.responsability;

import com.example.demo.behavorial.responsability.processor.CSRFAuthenticationProcessor;
import com.example.demo.behavorial.responsability.processor.JWTAuthenticationProcessor;
import com.example.demo.behavorial.responsability.processor.OAuthAuthenticationProcessor;
import com.example.demo.behavorial.responsability.provider.CSRFProvider;

/**
 * Patrón de responsabilidad:
 * Lo vemos en la seguridad de Spring a la hora de agregar filtros y si uno de ellos detecta que algo anda mal, se detiene la aplicación.
 * Los objetivos principales son reducir el acoplamiento, flexibilidad al permitir cambiar responsabilidad, componer un objeto que resuelva una unidad de trabajo.
 * Tener en cuenta:
 * Cada elemento de la cadena de responsabilidad tiene su propia implementación.
 * Cada elemento hace referencia al siguiente elemento.
 * No deberían formarse ciclos recursivos.
 */
public class Main {
    public static void main(String[] args) {

        AuthenticationProcessor jwt = new JWTAuthenticationProcessor(null);
        AuthenticationProcessor oauth = new OAuthAuthenticationProcessor(jwt);
        AuthenticationProcessor csrf = new CSRFAuthenticationProcessor(oauth);

        csrf.isAuthorized(new CSRFProvider());

    }
}
