package com.example.demo.controller;

import com.example.demo.entidades.Jugador;
import com.example.demo.repository.JugadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/jugadores")
public class JugadorController {

    @Autowired
    private JugadorRepository repo;

    @GetMapping
    public String listar(Model model) {
        model.addAttribute("titulo", "Listado de Jugadores");
        model.addAttribute("lista", repo.findAll());
        model.addAttribute("nuevoUrl", "/jugadores/nuevo");
        model.addAttribute("editarBaseUrl", "/jugadores/editar");
        model.addAttribute("eliminarBaseUrl", "/jugadores/eliminar");
        return "listar";
    }

    @GetMapping("/nuevo")
    public String nuevo(Model model) {
        model.addAttribute("titulo", "Nuevo Jugador");
        model.addAttribute("objeto", new Jugador());
        model.addAttribute("guardarUrl", "/jugadores/guardar");
        return "form";
    }

    @PostMapping("/guardar")
    public String guardar(@ModelAttribute Jugador jugador) {
        repo.save(jugador);
        return "redirect:/jugadores";
    }

    @GetMapping("/editar/{id}")
    public String editar(@PathVariable Long id, Model model) {
        model.addAttribute("titulo", "Editar Jugador");
        model.addAttribute("objeto", repo.findById(id).orElse(null));
        model.addAttribute("guardarUrl", "/jugadores/guardar");
        return "form";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable Long id) {
        repo.deleteById(id);
        return "redirect:/jugadores";
    }
}
