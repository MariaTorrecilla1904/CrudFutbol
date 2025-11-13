package com.example.demo.controller;

import com.example.demo.entidades.Asociacion;
import com.example.demo.repository.AsociacionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/asociaciones")
public class AsociacionController {

    @Autowired
    private AsociacionRepository repo;

    @GetMapping
    public String listar(Model model) {
        model.addAttribute("titulo", "Listado de Asociaciones");
        model.addAttribute("lista", repo.findAll());
        model.addAttribute("nuevoUrl", "/asociaciones/nuevo");
        model.addAttribute("editarBaseUrl", "/asociaciones/editar");
        model.addAttribute("eliminarBaseUrl", "/asociaciones/eliminar");
        return "listar";
    }

    @GetMapping("/nuevo")
    public String nuevo(Model model) {
        model.addAttribute("titulo", "Nueva Asociación");
        model.addAttribute("objeto", new Asociacion());
        model.addAttribute("guardarUrl", "/asociaciones/guardar");
        return "form";
    }

    @PostMapping("/guardar")
    public String guardar(@ModelAttribute Asociacion asociacion) {
        repo.save(asociacion);
        return "redirect:/asociaciones";
    }

    @GetMapping("/editar/{id}")
    public String editar(@PathVariable Long id, Model model) {
        model.addAttribute("titulo", "Editar Asociación");
        model.addAttribute("objeto", repo.findById(id).orElse(null));
        model.addAttribute("guardarUrl", "/asociaciones/guardar");
        return "form";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable Long id) {
        repo.deleteById(id);
        return "redirect:/asociaciones";
    }
}
