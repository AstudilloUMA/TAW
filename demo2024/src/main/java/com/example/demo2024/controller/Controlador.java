package com.example.demo2024.controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

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

    @GetMapping("/elegirGenero")
    public String doGenero () { return "genero.jsp"; }

    @PostMapping("/procesarGenero")
    public String doProcesar (@RequestParam("genero") String genero, Model modelo, HttpSession session) {
        session.setAttribute("genero",genero);

        return "tipo.jsp";
    }

    @PostMapping("/recogerTipo")
    public String doTipo (@RequestParam("tipo") String tipo, Model modelo, HttpSession session)
    {
        session.setAttribute("tipo", tipo);

        List<String> opciones = new ArrayList<>();

        if (session.getAttribute("genero").equals("terror")) {
            if (session.getAttribute("tipo").equals("series")) {
                opciones.add("The Walking Dead");
                opciones.add("TWD Daryl Dixon");
                opciones.add("Fear The Walking Dead");
            } else {
                opciones.add("It");
                opciones.add("Insidious");
                opciones.add("Expediente Warren");
            }
        } else if (session.getAttribute("genero").equals("ciencia ficci&oacuten")) {
            if (session.getAttribute("tipo").equals("series")) {
                opciones.add("The Clone Wars");
                opciones.add("Star Trek Discovery");
                opciones.add("The Mandalorian");
            } else {
                opciones.add("Star Trek");
                opciones.add("Star Wars");
                opciones.add("Time");
            }
        } else {
            if (session.getAttribute("tipo").equals("series")) {
                opciones.add("The Big Bang Theory");
                opciones.add("Modern Family");
                opciones.add("Me llamo Earl");
            } else {
                opciones.add("Niños Grandes");
                opciones.add("Ocho Apellidos Vascos");
                opciones.add("Jack y su Gemela");
            }
        }

        modelo.addAttribute(opciones);
        return "multimedia.jsp";

    }


    /*
    @PostMapping("/mostrarMultimedia")
    public String doMostrar(@RequestParam("modPrev") Model modPrev, @RequestParam("opcion") String[] opciones, Model modelo)
    {
        int i = 0;
        for(String opcion : opciones)
        {
            modPrev.addAttribute("s"+i, opcion);
            i++;
        }

        modelo = modPrev;
        return "informe.jsp";
    }
    */



}
