package com.forms.backend.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController // Define este controlador como API REST
@RequestMapping("/api") // Prefijo para todas las rutas de este controlador
public class HelloControllers {
    @GetMapping("/hello")  // Ruta GET /api/hello
    public String sayHello() {
        return "¡Hola Mundo desde Spring Boot!";
    } 
}
