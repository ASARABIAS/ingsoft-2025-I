package com.biblioteca.controller;

import com.biblioteca.model.Prestamo;
import com.biblioteca.service.BibliotecaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.logging.Logger;

@RestController
@RequestMapping("/api/prestamos")
public class PrestamoController {
    private static final Logger logger = Logger.getLogger(PrestamoController.class.getName());

    @Autowired
    private BibliotecaService bibliotecaService;

    @PostMapping
    public ResponseEntity<Prestamo> realizarPrestamo(@RequestParam Long usuarioId,
                                                     @RequestParam Long libroId) {
        // VIOLACIÓN: Controller maneja lógica de negocio
        if (usuarioId == null || libroId == null) {
            logger.warning("Parámetros inválidos para préstamo");
            return ResponseEntity.badRequest().build();
        }

        try {
            Prestamo prestamo = bibliotecaService.realizarPrestamo(usuarioId, libroId);
            logger.info("Préstamo realizado exitosamente: " + prestamo.getId());
            return ResponseEntity.ok(prestamo);
        } catch (RuntimeException e) {
            logger.severe("Error al realizar préstamo: " + e.getMessage());
            return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping("/{id}/devolver")
    public ResponseEntity<Void> devolverLibro(@PathVariable Long id) {
        try {
            bibliotecaService.devolverLibro(id);
            return ResponseEntity.ok().build();
        } catch (RuntimeException e) {
            logger.severe("Error al devolver libro: " + e.getMessage());
            return ResponseEntity.badRequest().build();
        }
    }

    // VIOLACIÓN SRP: Controller ejecuta procesos batch
    @PostMapping("/enviar-recordatorios")
    public ResponseEntity<String> enviarRecordatorios() {
        try {
            String rcordatorios=bibliotecaService.enviarRecordatoriosVencimiento();
            if(rcordatorios.isEmpty()){
                return ResponseEntity.ok("No hay prestamos VENCIDOS - No se enviaron recordatorios");
            }else {
                return ResponseEntity.ok("Recordatorios enviados exitosamente: <br>" + rcordatorios);
            }
        } catch (Exception e) {
            logger.severe("Error enviando recordatorios: " + e.getMessage());
            return ResponseEntity.internalServerError()
                    .body("Error enviando recordatorios");
        }
    }
}