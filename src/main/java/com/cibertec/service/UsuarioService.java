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

    // 1. Listar todos
    public List<Usuario> listarUsuarios() {
        return usuarioRepository.findAll();
    }

    // 2. Guardar (sirve para insertar y actualizar)
    public Usuario guardarUsuario(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    // 3. Buscar por ID (NUEVO - necesario para editar o ver detalles)
    public Usuario buscarPorId(Long id) {
        return usuarioRepository.findById(id).orElse(null);
    }

    // 4. Eliminar (NUEVO - necesario para el Controller)
    public void eliminarUsuario(Long id) {
        usuarioRepository.deleteById(id);
    }

    // 5. Buscar por Username (para el Login)
    public Usuario buscarPorUsername(String username) {
        return usuarioRepository.findByUsername(username);
    }
}