package com.cibertec.service;

import com.cibertec.model.Usuario;
import com.cibertec.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public Usuario buscarPorUsername(String username) {
        return usuarioRepository.findByUsername(username); // Nota: Debes crear este método en tu Repository
    }

    public Usuario guardarUsuario(Usuario usuario) {
        // Aquí podrías encriptar la clave antes de guardar
        return usuarioRepository.save(usuario);
    }
    
    public List<Usuario> listarUsuarios() {
        return usuarioRepository.findAll();
    }
}