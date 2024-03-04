package com.example.demo2024.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class Controlador {


    @GetMapping("/")
    public String doInicio () {
        return "formulario.html";
    }

    @PostMapping("/calcular")
    public String doFormulario (@RequestParam("op1") Integer op1, @RequestParam("op2") Integer op2,
                                @RequestParam("op") String op, Model modelo) {

        modelo.addAttribute("op1", op1);
        modelo.addAttribute("op2", op2);
        modelo.addAttribute("op", op);

        Integer res;
        if(op.equals("+")) res = op1 + op2;
        else if (op.equals("-")) res = op1 - op2;
        else if (op.equals("*")) res = op1 * op2;
        else res = op1 / op2;

        modelo.addAttribute("res", res);

        return "calculadora.jsp";
    }


}
