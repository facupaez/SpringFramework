package com.example.demo.behavorial.template;

public class HtmlHome extends HtmlTemplate {
    @Override
    public String head() {
        return """
                <!DOCTYPE html>
                <html lang="en" xmlns:th="http://www.thymeleaf.org">
                    <head>
                        <meta charset="UTF-8">
                        <title>Página de inicio</title>
                        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
                    </head>
                    <body>
                """;
    }

    @Override
    public String body() {
        return """
                            <h1>Hola desde Home</h1>
                """;
    }

    @Override
    public String footer() {
        return """
                        <footer>
                            <span>Copyright 2023<span>
                        </footer>
                    </body>
                </html>
                """;
    }
}
