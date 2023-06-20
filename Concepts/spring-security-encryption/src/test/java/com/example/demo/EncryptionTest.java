package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.security.crypto.argon2.Argon2PasswordEncoder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.password.Pbkdf2PasswordEncoder;
import org.springframework.security.crypto.scrypt.SCryptPasswordEncoder;

import java.util.HashMap;
import java.util.Map;

public class EncryptionTest {

    /**
     * BCrypt genera su propia 'salt' de 16 bytes
     * <p>
     * El resultado de cifrar con BCrypt será un string de 60 caracteres:
     * $a: versión.
     * $10: fuerza. (va desde 4 a 31, por defecto vale 10)
     * Los 22 siguientes caracteres son el salt generado.
     */
    @Test
    void bCryptTest() {

        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String hashedPassword = passwordEncoder.encode("admin");
        System.out.println(hashedPassword);

        // verificar coicidencia de passwords
        Boolean matches = passwordEncoder.matches("admin", hashedPassword);
        System.out.println(matches);
    }

    @Test
    void bCryptMultiplePasswords() {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

        for (int i = 0; i < 10; i++) {
            System.out.println(passwordEncoder.encode("admin"));
        }
    }

   /* @Test
    void pbkdf2() {
        int secretKeyFactoryAlgorithm = 1;
        Pbkdf2PasswordEncoder passwordEncoder = new Pbkdf2PasswordEncoder("salt", 10000, 128, secretKeyFactoryAlgorithm);

        for (int i = 0; i < 10; i++) {
            System.out.println(passwordEncoder.encode("admin"));
        }
    }*/


   /* @Test
    void argon() {
        int saltLength = 16; // salt length in bytes
        int hashLength = 32; // hash length in bytes
        int parallelism = 1; // currently not supported by Spring Security
        int memory = 4096;   // memory costs
        int iterations = 3;

        Argon2PasswordEncoder argon2PasswordEncoder = new Argon2PasswordEncoder(
                saltLength,
                hashLength,
                parallelism,
                memory,
                iterations);

        System.out.println(argon2PasswordEncoder.encode("admin"));
    }*/

  /*  @Test
    void scrypt() {
        int cpuCost = (int) Math.pow(2, 14); // factor to increase CPU costs
        int memoryCost = 8; // factor to increases memory usage
        int parallelization = 1; // currently  nor supported by Spring Security
        int keyLength = 32; // key length in bytes
        int saltLength = 64; // salt length in bytes

        SCryptPasswordEncoder passwordEncoder = new SCryptPasswordEncoder(cpuCost,
                memoryCost,
                parallelization,
                keyLength,
                saltLength);

        System.out.println(passwordEncoder.encode("admin"));
    }*/

}
