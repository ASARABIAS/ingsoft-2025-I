package com.biblioteca.controller;

import com.biblioteca.service.reporte.ReporteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.logging.Logger;

@RestController
@RequestMapping("/api/libros")
public class GeneraReporteController {
    private static final Logger logger = Logger.getLogger(GeneraReporteController.class.getName());

    @Autowired
    private ReporteService reporteService;

    @GetMapping("/{id}/reporte")
    public ResponseEntity<String> generarReporteLibro(@PathVariable Long id) {
        var reporte = reporteService.generarReporteLibro(id);

        if (reporte.length() > 1) {
            return ResponseEntity.ok(reporte);
        } else {
            return ResponseEntity.notFound().build();
        }

    }
}
