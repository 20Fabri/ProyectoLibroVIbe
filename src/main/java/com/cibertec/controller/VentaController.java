package com.cibertec.controller;

import com.cibertec.model.Venta;
import com.cibertec.service.VentaService;
import com.cibertec.service.UsuarioService;
import com.cibertec.service.LibroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/ventas")
public class VentaController {

    @Autowired
    private VentaService ventaService;

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private LibroService libroService;

    @GetMapping
    public String listarVentas(Model model) {
        // CORRECCIÓN: Tu Service tiene "listarVentas()", no "listarTodas()"
        model.addAttribute("listaVentas", ventaService.listarVentas());
        return "ventas/lista";
    }

    @GetMapping("/nueva")
    public String nuevaVenta(Model model) {
        model.addAttribute("venta", new Venta());
        // CORRECCIÓN: Verifica que en UsuarioService el método sea "listarUsuarios"
        model.addAttribute("usuarios", usuarioService.listarUsuarios());
        // CORRECCIÓN: Verifica que en LibroService el método sea "listarTodos"
        model.addAttribute("libros", libroService.listarTodos());
        return "ventas/formulario";
    }

    @PostMapping("/guardar")
    public String guardarVenta(@ModelAttribute Venta venta) {
        // CORRECCIÓN: Tu Service tiene "realizarVenta()", no "registrarVenta()"
        ventaService.realizarVenta(venta);
        return "redirect:/ventas";
    }
}