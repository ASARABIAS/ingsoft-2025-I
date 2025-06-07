package com.biblioteca.dto;

import lombok.Data;

@Data
public class LibroDTO {
    private String titulo;
    private String autor;
    private String isbn;
    private String categoria;
    private Integer copias;

    // VIOLACIÓN SRP: DTO con lógica de validación
    public boolean esValido() {
        return titulo != null && !titulo.trim().isEmpty() &&
                autor != null && !autor.trim().isEmpty() &&
                isbn != null && isbn.length() >= 10 &&
                copias != null && copias > 0;
    }

    // VIOLACIÓN: DTO con lógica de negocio
    public String generarCodigoInterno() {
        return categoria.substring(0, 3).toUpperCase() + "-" +
                isbn.substring(isbn.length() - 4);
    }
}