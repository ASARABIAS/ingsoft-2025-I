package com.biblioteca.service.libro.busqueda;

import com.biblioteca.model.Libro;

import java.util.List;

public interface EstrategiaBusqueda {
    boolean soporta(String criterio);
    List<Libro> buscar(String criterio);
}
