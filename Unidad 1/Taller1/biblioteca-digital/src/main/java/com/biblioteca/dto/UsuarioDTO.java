package com.biblioteca.dto;

import lombok.Data;

@Data
public class UsuarioDTO {
    private String nombre;
    private String email;
    private String telefono;
    private String direccion;
    private String tipoUsuario;

    // VIOLACIÓN SRP: DTO con validación
    public boolean tieneEmailValido() {
        return email != null && email.contains("@") && email.contains(".");
    }

    public boolean tieneTelefonoValido() {
        return telefono != null && telefono.matches("\\d{10}");
    }
}
