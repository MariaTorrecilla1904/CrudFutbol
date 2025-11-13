package com.example.demo.controller;

import com.example.demo.entidades.Club;
import com.example.demo.repository.ClubRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/clubes")
public class ClubController {

    @Autowired
    private ClubRepository repo;

    @GetMapping
    public String listar(Model model) {
        model.addAttribute("titulo", "Listado de Clubes");
        model.addAttribute("lista", repo.findAll());
        model.addAttribute("nuevoUrl", "/clubes/nuevo");
        model.addAttribute("editarBaseUrl", "/clubes/editar");
        model.addAttribute("eliminarBaseUrl", "/clubes/eliminar");
        return "listar";
    }

    @GetMapping("/nuevo")
    public String nuevo(Model model) {
        model.addAttribute("titulo", "Nuevo Club");
        model.addAttribute("objeto", new Club());
        model.addAttribute("guardarUrl", "/clubes/guardar");
        return "form";
    }

    @PostMapping("/guardar")
    public String guardar(@ModelAttribute Club club) {
        repo.save(club);
        return "redirect:/clubes";
    }

    @GetMapping("/editar/{id}")
    public String editar(@PathVariable Long id, Model model) {
        model.addAttribute("titulo", "Editar Club");
        model.addAttribute("objeto", repo.findById(id).orElse(null));
        model.addAttribute("guardarUrl", "/clubes/guardar");
        return "form";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable Long id) {
        repo.deleteById(id);
        return "redirect:/clubes";
    }
}
