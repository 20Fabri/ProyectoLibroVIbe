package com.cibertec.controller;

import com.cibertec.model.Libro;
import com.cibertec.service.LibroService;
import com.cibertec.service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/libros") // Todas las rutas del navegador empezarán con /libros
public class LibroController {

    @Autowired
    private LibroService libroService;

    @Autowired
    private CategoriaService categoriaService;

    // 1. Listar Libros: La página principal donde se verán las fotos y el catálogo
    @GetMapping
    public String listarLibros(Model model) {
        // "listaLibros" es el nombre que usaremos en el HTML (Thymeleaf) para el bucle
        model.addAttribute("listaLibros", libroService.listarTodos());
        return "libros/lista"; // Busca en src/main/resources/templates/libros/lista.html
    }

    // 2. Mostrar formulario para registrar un nuevo libro
    @GetMapping("/nuevo")
    public String formularioNuevo(Model model) {
        model.addAttribute("libro", new Libro()); // Objeto vacío para el formulario
        model.addAttribute("categorias", categoriaService.listarCategorias()); // Para el desplegable
        return "libros/formulario";
    }

    // 3. Guardar el libro: Recibe los datos del formulario y los procesa
    @PostMapping("/guardar")
    public String guardarLibro(@ModelAttribute Libro libro) {
        libroService.guardar(libro);
        return "redirect:/libros"; // Al terminar, nos manda de vuelta a la lista
    }

    // 4. Eliminar libro: Recibe el ID por la URL
    @GetMapping("/eliminar/{id}")
    public String eliminarLibro(@PathVariable Long id) {
        libroService.eliminar(id);
        return "redirect:/libros";
    } 
}