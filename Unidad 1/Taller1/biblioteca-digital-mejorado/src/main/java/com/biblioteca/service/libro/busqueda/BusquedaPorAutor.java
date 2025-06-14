package com.biblioteca.service.libro.busqueda;

import com.biblioteca.model.Libro;
import com.biblioteca.repository.LibroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class BusquedaPorAutor implements EstrategiaBusqueda {

    @Autowired
    private LibroRepository libroRepository;

    @Override
    public boolean soporta(String criterio) {
        return criterio.startsWith("AUTOR:");
    }

    @Override
    public List<Libro> buscar(String criterio) {
        var autor = criterio.substring(6).trim();
        return libroRepository.findByAutorContaining(autor);
    }
}
