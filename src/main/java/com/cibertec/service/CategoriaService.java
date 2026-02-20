package com.cibertec.service;

import com.cibertec.model.Categoria;
import com.cibertec.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository categoriaRepository;

    public List<Categoria> listarCategorias() {
        return categoriaRepository.findAll();
    }
 // NUEVO MÉTODO - Guardar: Para registrar o actualizar categorías
    public void guardar(Categoria categoria) {
        categoriaRepository.save(categoria);
    }
}
