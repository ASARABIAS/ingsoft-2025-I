package com.biblioteca.controller;

import com.biblioteca.model.Libro;
import com.biblioteca.dto.LibroDTO;
import com.biblioteca.service.libro.LibroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.logging.Logger;

@RestController
@RequestMapping("/api/libros")
public class LibroController {
    private static final Logger logger = Logger.getLogger(LibroController.class.getName());

    @Autowired
    private LibroService libroService;

    @PostMapping
    public ResponseEntity<?> crearLibro(@RequestBody LibroDTO libroDTO) {
        try {
            var libroCreado = libroService.crearLibro(libroDTO);
            return ResponseEntity.ok(libroCreado);
        } catch (IllegalArgumentException ex) {
            logger.warning("Error al crear libro: " + ex.getMessage());
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
    }

    @GetMapping("/buscar")
    public ResponseEntity<?> buscarLibros(@RequestParam String criterio) {
        try {
            List<Libro> libros = libroService.buscarLibros(criterio);
            return ResponseEntity.ok(libros);
        } catch (IllegalArgumentException ex) {
            logger.warning("Error al buscar libros: " + ex.getMessage());
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> obtenerLibro(@PathVariable Long id) {
        try {
            var libro = libroService.getLibro(id);
            logger.info("Consultando libro: " + libro.getTitulo());
            return ResponseEntity.ok(libro);
        } catch (NoSuchElementException ex) {
            logger.warning("Libro no encontrado con ID: " + id);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
        } catch (Exception ex) {
            logger.severe("Error interno al obtener libro: " + ex.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al procesar la solicitud");
        }
    }
}
