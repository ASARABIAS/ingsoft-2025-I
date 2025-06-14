package com.biblioteca.service.libro.utils;

import com.biblioteca.dto.LibroDTO;
import com.biblioteca.model.Libro;

public class LibroMapper {

    public static Libro toEntity(LibroDTO dto) {
        Libro libro = new Libro();
        libro.setTitulo(dto.getTitulo());
        libro.setAutor(dto.getAutor());
        libro.setIsbn(dto.getIsbn());
        libro.setCategoria(dto.getCategoria());
        libro.setCopias(dto.getCopias());
        return libro;
    }
}
