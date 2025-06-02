package com.biblioteca.model;

import com.biblioteca.service.NotificacionService;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "libros")
@Data
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Libro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;
    private String autor;
    private String isbn;
    private String categoria;
    private Integer copias;
    private Integer copiasDisponibles;
    private LocalDateTime fechaCreacion;

    // VIOLACIÓN SRP: Lógica de negocio en entidad
    public boolean puedeSerPrestado() {
        return copiasDisponibles > 0 && !esLibroRestringido();
    }

    public boolean esLibroRestringido() {
        return categoria.equals("REFERENCIA") || categoria.equals("ESPECIAL");
    }

    // VIOLACIÓN OCP: Lógica hardcodeada difícil de extender
    public double calcularCostoRetraso(int diasRetraso) {
        if (categoria.equals("NORMAL")) {
            return diasRetraso * 0.5;
        } else if (categoria.equals("PREMIUM")) {
            return diasRetraso * 1.0;
        } else if (categoria.equals("ESPECIAL")) {
            return diasRetraso * 2.0;
        }
        return 0.0;
    }

    // VIOLACIÓN DIP: Dependencia directa de implementación concreta
    public void enviarNotificacionDisponibilidad() {
        // Directamente instancia una clase concreta
        NotificacionService notificacion = new NotificacionService();
        notificacion.enviarEmail("libro.disponible@biblioteca.com",
                "Libro disponible: " + titulo);
    }

    // VIOLACIÓN ISP: Método que no todos los libros necesitan
    public String generarCodigoBarras() {
        return "BAR-" + isbn + "-" + System.currentTimeMillis();
    }
}