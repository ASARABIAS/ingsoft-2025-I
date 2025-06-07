package com.biblioteca.model;

import com.biblioteca.service.NotificacionService;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

@Entity
@Table(name = "prestamos")
@Data
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})

public class Prestamo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "libro_id")
    private Libro libro;

    private LocalDateTime fechaPrestamo;
    private LocalDateTime fechaDevolucionEsperada;
    private LocalDateTime fechaDevolucionReal;
    private String estado; // ACTIVO, DEVUELTO, VENCIDO

    // VIOLACIÓN SRP: Prestamo maneja validaciones, cálculos Y notificaciones
    public boolean estaVencido() {
        return LocalDateTime.now().isAfter(fechaDevolucionEsperada) &&
                fechaDevolucionReal == null;
    }

    public long getDiasRetraso() {
        if (fechaDevolucionReal != null) {
            return ChronoUnit.DAYS.between(fechaDevolucionEsperada, fechaDevolucionReal);
        }
        return ChronoUnit.DAYS.between(fechaDevolucionEsperada, LocalDateTime.now());
    }

    // VIOLACIÓN DIP: Dependencia directa de clases concretas
    public double calcularMulta() {
        long diasRetraso = getDiasRetraso();
        if (diasRetraso <= 0) return 0.0;

        // Directamente usa el método del libro (alto acoplamiento)
        return libro.calcularCostoRetraso((int) diasRetraso);
    }

    // VIOLACIÓN SRP: Prestamo envía sus propias notificaciones
    public void enviarNotificacionVencimiento() {
        NotificacionService notificacion = new NotificacionService();
        String mensaje = String.format("Su préstamo del libro '%s' está vencido",
                libro.getTitulo());
        notificacion.enviarEmail(usuario.getEmail(), mensaje);
    }

    public void renovar() {
        // VIOLACIÓN: Lógica de negocio compleja en entidad
        if (estaVencido()) {
            throw new IllegalStateException("No se puede renovar un préstamo vencido");
        }

        if (!usuario.puedeRealizarPrestamo()) {
            throw new IllegalStateException("Usuario no puede realizar más préstamos");
        }

        // Extiende por el mismo período original
        long diasOriginales = ChronoUnit.DAYS.between(fechaPrestamo, fechaDevolucionEsperada);
        fechaDevolucionEsperada = LocalDateTime.now().plusDays(diasOriginales);

        // Envía notificación (violación SRP)
        NotificacionService notificacion = new NotificacionService();
        notificacion.enviarEmail(usuario.getEmail(), "Préstamo renovado exitosamente");
    }
}