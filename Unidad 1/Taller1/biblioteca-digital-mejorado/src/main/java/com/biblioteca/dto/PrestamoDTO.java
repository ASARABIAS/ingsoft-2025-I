package com.biblioteca.dto;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class PrestamoDTO {
    private Long usuarioId;
    private Long libroId;
    private LocalDateTime fechaPrestamo;
    private LocalDateTime fechaDevolucionEsperada;
    private String estado;
}
