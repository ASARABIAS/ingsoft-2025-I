package com.biblioteca.service.libro.utils;

import com.biblioteca.dto.LibroDTO;
import com.biblioteca.model.Libro;

import java.util.List;

public class LibroValidator {

    public static void validarDatos(LibroDTO dto){
        if (dto.getTitulo() == null || dto.getTitulo().trim().isEmpty()) {
            throw new IllegalArgumentException("El título no puede estar vacío");
        }
        if (dto.getCopias() == null || dto.getCopias() <= 0) {
            throw new IllegalArgumentException("El número de copias debe ser mayor a cero");
        }
    }

    public static void validarCriterioBusqueda(String criterio) {
        if (criterio == null || criterio.trim().length() < 3) {
            throw new IllegalArgumentException("El criterio de búsqueda debe tener al menos 3 caracteres.");
        }
    }
}
