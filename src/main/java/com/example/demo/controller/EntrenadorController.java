package com.example.demo.controller;

import com.example.demo.entidades.Entrenador;
import com.example.demo.repository.EntrenadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/entrenadores")
public class EntrenadorController {

    @Autowired
    private EntrenadorRepository repo;

    @GetMapping
    public String listar(Model model) {
        model.addAttribute("titulo", "Listado de Entrenadores");
        model.addAttribute("lista", repo.findAll());
        model.addAttribute("nuevoUrl", "/entrenadores/nuevo");
        model.addAttribute("editarBaseUrl", "/entrenadores/editar");
        model.addAttribute("eliminarBaseUrl", "/entrenadores/eliminar");
        return "listar";
    }

    @GetMapping("/nuevo")
    public String nuevo(Model model) {
        model.addAttribute("titulo", "Nuevo Entrenador");
        model.addAttribute("objeto", new Entrenador());
        model.addAttribute("guardarUrl", "/entrenadores/guardar");
        return "form";
    }

    @PostMapping("/guardar")
    public String guardar(@ModelAttribute Entrenador entrenador) {
        repo.save(entrenador);
        return "redirect:/entrenadores";
    }

    @GetMapping("/editar/{id}")
    public String editar(@PathVariable Long id, Model model) {
        model.addAttribute("titulo", "Editar Entrenador");
        model.addAttribute("objeto", repo.findById(id).orElse(null));
        model.addAttribute("guardarUrl", "/entrenadores/guardar");
        return "form";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable Long id) {
        repo.deleteById(id);
        return "redirect:/entrenadores";
    }
}
