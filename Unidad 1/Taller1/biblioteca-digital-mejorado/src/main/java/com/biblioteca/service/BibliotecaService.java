package com.biblioteca.service;

import com.biblioteca.model.*;
import com.biblioteca.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class BibliotecaService {

    @Autowired
    private LibroRepository libroRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private PrestamoRepository prestamoRepository;

    // VIOLACIÓN SRP: Un servicio que hace TODO

    // Gestión de libros
    public Libro crearLibro(Libro libro) {
        libro.setFechaCreacion(LocalDateTime.now());
        libro.setCopiasDisponibles(libro.getCopias());
        return libroRepository.save(libro);
    }

    public Libro getLibro(Long id){
        Libro libro = this.libroRepository.getReferenceById(id);
        return libro;
    }

    public List<Libro> buscarLibros(String criterio) {
        // VIOLACIÓN OCP: Lógica de búsqueda hardcodeada
        if (criterio.startsWith("ISBN:")) {
            return libroRepository.findByIsbn(criterio.substring(5));
        } else if (criterio.startsWith("AUTOR:")) {
            return libroRepository.findByAutorContaining(criterio.substring(6));
        } else {
            return libroRepository.findByTituloContaining(criterio);
        }
    }

    // Gestión de usuarios
    public Usuario registrarUsuario(Usuario usuario) {
        usuario.setFechaRegistro(LocalDateTime.now());
        usuario.setActivo(true);

        // VIOLACIÓN DIP: Dependencia directa de NotificacionService
        NotificacionService notificacion = new NotificacionService();
        notificacion.enviarEmail(usuario.getEmail(), "Bienvenido a la biblioteca digital");

        return usuarioRepository.save(usuario);
    }

    public boolean validarUsuario(Long usuarioId) {
        Optional<Usuario> usuario = usuarioRepository.findById(usuarioId);
        if (usuario.isEmpty()) return false;

        Usuario u = usuario.get();
        return u.isActivo() && u.contarPrestamosActivos() < u.getLimitePrestamos();
    }

    // Gestión de préstamos
    public Prestamo realizarPrestamo(Long usuarioId, Long libroId) {
        // VIOLACIÓN: Método muy largo con múltiples responsabilidades
        Usuario usuario = usuarioRepository.findById(usuarioId)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

        Libro libro = libroRepository.findById(libroId)
                .orElseThrow(() -> new RuntimeException("Libro no encontrado"));

        // Validaciones (debería estar en otro lugar)
        if (!usuario.puedeRealizarPrestamo()) {
            throw new RuntimeException("Usuario no puede realizar préstamos");
        }

        if (!libro.puedeSerPrestado()) {
            throw new RuntimeException("Libro no disponible para préstamo");
        }

        // Crear préstamo
        Prestamo prestamo = new Prestamo();
        prestamo.setUsuario(usuario);
        prestamo.setLibro(libro);
        prestamo.setFechaPrestamo(LocalDateTime.now());
        prestamo.setFechaDevolucionEsperada(
                LocalDateTime.now().plusDays(usuario.getDiasPrestamo())
        );
        prestamo.setEstado("ACTIVO");

        // Actualizar disponibilidad
        libro.setCopiasDisponibles(libro.getCopiasDisponibles() - 1);
        libroRepository.save(libro);

        // Guardar préstamo
        prestamo = prestamoRepository.save(prestamo);

        // Enviar notificaciones (VIOLACIÓN SRP)
        NotificacionService notificacion = new NotificacionService();
        String mensaje = String.format("Préstamo realizado: %s. Fecha devolución: %s",
                libro.getTitulo(),
                prestamo.getFechaDevolucionEsperada());
        notificacion.enviarEmail(usuario.getEmail(), mensaje);

        return prestamo;
    }

    public void devolverLibro(Long prestamoId) {
        Prestamo prestamo = prestamoRepository.findById(prestamoId)
                .orElseThrow(() -> new RuntimeException("Préstamo no encontrado"));

        prestamo.setFechaDevolucionReal(LocalDateTime.now());
        prestamo.setEstado("DEVUELTO");

        // Actualizar disponibilidad
        Libro libro = prestamo.getLibro();
        libro.setCopiasDisponibles(libro.getCopiasDisponibles() + 1);
        libroRepository.save(libro);

        // Calcular multa si hay retraso
        double multa = prestamo.calcularMulta();
        if (multa > 0) {
            // VIOLACIÓN: Lógica de multas mezclada con devolución
            NotificacionService notificacion = new NotificacionService();
            String mensaje = String.format("Multa por retraso: $%.2f", multa);
            notificacion.enviarEmail(prestamo.getUsuario().getEmail(), mensaje);
        }

        prestamoRepository.save(prestamo);
    }

    // Reportes (VIOLACIÓN SRP: no debería estar aquí)
    public String generarReporteUsuario(Long usuarioId) {
        Usuario usuario = usuarioRepository.findById(usuarioId)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

        StringBuilder reporte = new StringBuilder();
        reporte.append("===== REPORTE DE USUARIO =====<br>");
        reporte.append("Nombre: ").append(usuario.getNombre()).append("<br>");
        reporte.append("Email: ").append(usuario.getEmail()).append("<br>");
        reporte.append("Préstamos activos: ").append(usuario.contarPrestamosActivos()).append("<br>");
        reporte.append("===============================").append("<br>");
        return reporte.toString();
    }

    // Notificaciones masivas (VIOLACIÓN SRP)
    public String enviarRecordatoriosVencimiento() {
        List<Prestamo> prestamosVencidos = prestamoRepository.findByEstado("VENCIDO");
        NotificacionService notificacion = new NotificacionService();
        StringBuilder notificacionesEnviadas = new StringBuilder();

        for (Prestamo prestamo : prestamosVencidos) {
            String mensaje = String.format("Recordatorio: El libro '%s' debe ser devuelto",
                    prestamo.getLibro().getTitulo());
            notificacionesEnviadas.append(notificacion.enviarEmail(prestamo.getUsuario().getEmail(), mensaje)).append("<br>");
        }

        return notificacionesEnviadas.toString();
    }
}