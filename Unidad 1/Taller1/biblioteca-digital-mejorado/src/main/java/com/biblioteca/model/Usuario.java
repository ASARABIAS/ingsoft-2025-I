package com.biblioteca.model;

import com.biblioteca.service.NotificacionService;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;
import java.util.List;
import java.util.ArrayList;

@Entity
@Table(name = "usuarios")
@Data
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})

public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private String email;
    private String telefono;
    private String direccion;
    private String tipoUsuario; // ESTUDIANTE, PROFESOR, ADMINISTRATIVO
    private LocalDateTime fechaRegistro;
    private boolean activo;

    // VIOLACIÓN SRP: Usuario maneja sus propios préstamos Y validaciones Y notificaciones
    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL)
    private List<Prestamo> prestamos = new ArrayList<>();

    public boolean puedeRealizarPrestamo() {
        return activo && contarPrestamosActivos() < getLimitePrestamos() && !tienePrestamosVencidos();
    }

    public int contarPrestamosActivos() {
        return (int) prestamos.stream()
                .filter(p -> p.getEstado().equals("ACTIVO"))
                .count();
    }

    // VIOLACIÓN OCP: Lógica hardcodeada para tipos de usuario
    public int getLimitePrestamos() {
        switch (tipoUsuario) {
            case "ESTUDIANTE": return 3;
            case "PROFESOR": return 10;
            case "ADMINISTRATIVO": return 5;
            default: return 1;
        }
    }

    public int getDiasPrestamo() {
        switch (tipoUsuario) {
            case "ESTUDIANTE": return 15;
            case "PROFESOR": return 30;
            case "ADMINISTRATIVO": return 20;
            default: return 7;
        }
    }

    // VIOLACIÓN DIP y SRP: Usuario se encarga de notificaciones
    public void enviarRecordatorio() {
        NotificacionService notificacion = new NotificacionService();
        String mensaje = "Estimado " + nombre + ", tienes préstamos por devolver.";
        notificacion.enviarEmail(email, mensaje);
        notificacion.enviarSMS(telefono, mensaje);
    }

    // VIOLACIÓN LSP: Método que no aplica a todos los tipos de usuario
    public void generarCredencialProfesor() {
        if (!tipoUsuario.equals("PROFESOR")) {
            throw new UnsupportedOperationException("Solo profesores pueden generar credenciales");
        }
        // Lógica específica para profesores
    }

    private boolean tienePrestamosVencidos() {
        return prestamos.stream()
                .anyMatch(p -> p.estaVencido());
    }
}
