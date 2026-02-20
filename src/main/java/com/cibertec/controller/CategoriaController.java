package com.cibertec.controller;

import com.cibertec.model.Categoria;
import com.cibertec.service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/categorias")
public class CategoriaController {

    @Autowired
    private CategoriaService categoriaService;

    // Listar todas las categorías
    @GetMapping
    public String listarCategorias(Model model) {
        model.addAttribute("listaCategorias", categoriaService.listarCategorias());
        return "categorias/lista"; 
    }

    // Formulario para nueva categorías
    @GetMapping("/nuevo")
    public String formularioCategoria(Model model) {
        model.addAttribute("categoria", new Categoria());
        return "categorias/formulario";
    }

    // Guardar categoría
    @PostMapping("/guardar")
    public String guardarCategoria(@ModelAttribute Categoria categoria) {
        categoriaService.guardar(categoria);
        return "redirect:/categorias";
    }
}