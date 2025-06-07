package com.biblioteca.controller;

import com.biblioteca.model.Libro;
import com.biblioteca.service.BibliotecaService;
import com.biblioteca.dto.LibroDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.logging.Logger;

@RestController
@RequestMapping("/api/libros")
public class LibroController {
    private static final Logger logger = Logger.getLogger(LibroController.class.getName());

    @Autowired
    private BibliotecaService bibliotecaService;

    // VIOLACIÓN: Controller hace validación de negocio
    @PostMapping
    public ResponseEntity<Libro> crearLibro(@RequestBody LibroDTO libroDTO) {
        // Validación en controller (VIOLACIÓN SRP)
        if (libroDTO.getTitulo() == null || libroDTO.getTitulo().trim().isEmpty()) {
            logger.warning("Intento de crear libro sin título");
            return ResponseEntity.badRequest().build();
        }

        if (libroDTO.getCopias() == null || libroDTO.getCopias() <= 0) {
            logger.warning("Intento de crear libro con copias inválidas");
            return ResponseEntity.badRequest().build();
        }

        // VIOLACIÓN DIP: Conversión manual DTO -> Entity
        Libro libro = new Libro();
        libro.setTitulo(libroDTO.getTitulo());
        libro.setAutor(libroDTO.getAutor());
        libro.setIsbn(libroDTO.getIsbn());
        libro.setCategoria(libroDTO.getCategoria());
        libro.setCopias(libroDTO.getCopias());

        Libro libroCreado = bibliotecaService.crearLibro(libro);
        return ResponseEntity.ok(libroCreado);
    }

    @GetMapping("/buscar")
    public ResponseEntity<List<Libro>> buscarLibros(@RequestParam String criterio) {
        // VIOLACIÓN: Controller maneja lógica de negocio
        if (criterio == null || criterio.trim().length() < 3) {
            logger.warning("Criterio de búsqueda muy corto: " + criterio);
            return ResponseEntity.badRequest().build();
        }

        List<Libro> libros = bibliotecaService.buscarLibros(criterio);
        return ResponseEntity.ok().body(libros);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Libro> obtenerLibro(@PathVariable Long id) {
        // VIOLACIÓN: No hay separación clara de responsabilidades
        try {
            // Simulación de obtención (falta implementar)
            Libro libro = this.bibliotecaService.getLibro(id);
            logger.info("Consultando libro con ID: " + libro.getTitulo());
            return ResponseEntity.ok().body(libro);
        } catch (Exception e) {
            logger.severe("Error al obtener libro: " + e.getMessage());
            return ResponseEntity.notFound().build();
        }
    }

    // VIOLACIÓN SRP: Controller genera reportes
    @GetMapping("/{id}/reporte")
    public ResponseEntity<String> generarReporteLibro(@PathVariable Long id) {

        try {
            // Lógica de reporte mezclada en controller // Lógica de reporte mezclada en controller
            Libro libro = this.bibliotecaService.getLibro(id);
            logger.info("Consultando libro con ID: " + libro.getTitulo());
            StringBuilder reporte = new StringBuilder();
            reporte.append("======= REPORTE DE LIBRO =======").append("<br>");
            reporte.append("ID: ").append(id).append("<br>");
            reporte.append("TITULO: ").append(libro.getTitulo()).append("<br>");
            reporte.append("AUTOR: ").append(libro.getAutor()).append("<br>");
            reporte.append("ISBN: ").append(libro.getIsbn()).append("<br>");
            reporte.append("CATEGORIA: ").append(libro.getCategoria()).append("<br>");
            reporte.append("COPIAS: ").append(libro.getCopias()).append("<br>");
            reporte.append("================================").append("<br>");
            return ResponseEntity.ok(reporte.toString());

        } catch (Exception e) {
            logger.severe("Error al obtener libro: " + e.getMessage());
            return ResponseEntity.notFound().build();
        }




    }
}
