package com.example.deploy;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @Value("${app.message}")
    String message;
    @Value("${app.varexample}")
    String varexample;
    @Value("${app.varexample1}")
    String varexample1;

    @GetMapping("/hello")
    public String helloWorld(){
        System.out.println(message);
        System.out.println(varexample);
        System.out.println(varexample1);
        return "Hello world desde deploy!!";
    }

    @GetMapping("/bootstrap")
    public String bootstrap(){
        return """
                  <!doctype html>
                   <html lang="en">
                     <head>
                       <meta charset="utf-8">
                       <meta name="viewport" content="width=device-width, initial-scale=1">
                       <title>Bootstrap demo</title>
                       <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
                     </head>
                     <body>
                       <h1>Hello, world from Spring Boot with Bootstrap!</h1>
                       <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4" crossorigin="anonymous"></script>
                     </body>
                   </html>
                """;
    }
}
