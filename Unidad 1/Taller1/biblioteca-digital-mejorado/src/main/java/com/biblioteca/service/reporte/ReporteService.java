package com.biblioteca.service.reporte;

import com.biblioteca.controller.LibroController;
import com.biblioteca.model.Libro;
import com.biblioteca.repository.LibroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.logging.Logger;

@Service
public class ReporteService {

    private static final Logger logger = Logger.getLogger(ReporteService.class.getName());

    @Autowired
    private LibroRepository libroRepository;

    public String generarReporteLibro(Long id) {
        try {
            var libro = libroRepository.findById(id).orElseThrow();
            logger.info("Consultando libro con ID: " + libro.getTitulo());
            var reporte = new StringBuilder();
            reporte.append("======= REPORTE DE LIBRO =======").append("<br>");
            reporte.append("ID: ").append(id).append("<br>");
            reporte.append("TITULO: ").append(libro.getTitulo()).append("<br>");
            reporte.append("AUTOR: ").append(libro.getAutor()).append("<br>");
            reporte.append("ISBN: ").append(libro.getIsbn()).append("<br>");
            reporte.append("CATEGORIA: ").append(libro.getCategoria()).append("<br>");
            reporte.append("COPIAS: ").append(libro.getCopias()).append("<br>");
            reporte.append("================================").append("<br>");
            return reporte.toString();

        } catch (Exception e) {
            logger.severe("Error al obtener libro: " + e.getMessage());
            return "";
        }
    }

}
