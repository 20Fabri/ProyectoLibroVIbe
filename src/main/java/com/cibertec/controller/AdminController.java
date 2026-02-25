package com.cibertec.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RequestMapping;

import com.cibertec.model.Usuario;
import com.cibertec.service.LibroService;


import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/admin")
public class AdminController {
	@Autowired
    private LibroService libroService;


    @GetMapping("/dashboard")
    public String mostrarDashboard(HttpSession session, Model model) {
        // Verificamos que realmente sea admin antes de mostrar la página
        Usuario user = (Usuario) session.getAttribute("usuarioLogueado");
        
        if (user == null || !String.valueOf(user.getRol()).equals("ROLE_ADMIN")) {
            return "redirect:/login"; // Si no es admin, fuera
        }
     // Pasamos datos para las métricas del dashboard
        model.addAttribute("totalLibros", libroService.listarTodos().size());
        
        return "admin/dashboard"; // Esto busca en templates/admin/dashboard.html
    }
    
    
   
    
} 