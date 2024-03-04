package com.example.demo2024.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class Controlador {

    @GetMapping("/")
    public String doHello()
    {
        return "hola.html";
    }

    @GetMapping("/form")
    public String doForm()
    {
        return "form.html";
    }

    @PostMapping("/procesar")
    public String doProcesar(@RequestParam("nombre") String nombre,
                             @RequestParam("apellidos") String apellidos,
                             @RequestParam("edad") String edad)
    {
        return "nueva";
    }
}
