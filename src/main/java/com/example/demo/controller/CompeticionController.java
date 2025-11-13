package com.example.demo.controller;

import com.example.demo.entidades.Competicion;
import com.example.demo.repository.CompeticionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/competiciones")
public class CompeticionController {

    @Autowired
    private CompeticionRepository repo;

    @GetMapping
    public String listar(Model model) {
        model.addAttribute("titulo", "Listado de Competiciones");
        model.addAttribute("lista", repo.findAll());
        model.addAttribute("nuevoUrl", "/competiciones/nuevo");
        model.addAttribute("editarBaseUrl", "/competiciones/editar");
        model.addAttribute("eliminarBaseUrl", "/competiciones/eliminar");
        return "listar";
    }

    @GetMapping("/nuevo")
    public String nuevo(Model model) {
        model.addAttribute("titulo", "Nueva Competición");
        model.addAttribute("objeto", new Competicion());
        model.addAttribute("guardarUrl", "/competiciones/guardar");
        return "form";
    }

    @PostMapping("/guardar")
    public String guardar(@ModelAttribute Competicion competicion) {
        repo.save(competicion);
        return "redirect:/competiciones";
    }

    @GetMapping("/editar/{id}")
    public String editar(@PathVariable Long id, Model model) {
        model.addAttribute("titulo", "Editar Competición");
        model.addAttribute("objeto", repo.findById(id).orElse(null));
        model.addAttribute("guardarUrl", "/competiciones/guardar");
        return "form";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable Long id) {
        repo.deleteById(id);
        return "redirect:/competiciones";
    }
}
