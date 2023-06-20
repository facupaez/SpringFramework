package com.example.demo;

import com.example.demo.entities.User;
import com.example.demo.repositories.UserRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class SpringSecurityCifradoApplication {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    public static void main(String[] args) {

        ApplicationContext context = SpringApplication.run(SpringSecurityCifradoApplication.class, args);
        UserRepository repository = context.getBean(UserRepository.class);
        PasswordEncoder passwordEncoder = context.getBean(PasswordEncoder.class);

        User user = new User(null, "user", "admin");
        User userEncoded = new User(null, "user", passwordEncoder.encode("admin"));
        repository.save(user);
        repository.save(userEncoded);
    }

}
