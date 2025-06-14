package com.biblioteca.service.libro;

import com.biblioteca.dto.LibroDTO;
import com.biblioteca.model.Libro;
import com.biblioteca.repository.LibroRepository;
import com.biblioteca.service.libro.utils.LibroMapper;
import com.biblioteca.service.libro.utils.LibroValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class LibroService {

    @Autowired
    private LibroRepository libroRepository;
    @Autowired
    private  BuscadorLibro buscadorLibro;


    public Libro crearLibro(LibroDTO dto) {

        LibroValidator.validarDatos(dto);
        var libro = LibroMapper.toEntity(dto);
        libro.setFechaCreacion(LocalDateTime.now());
        libro.setCopiasDisponibles(libro.getCopias());
        return libroRepository.save(libro);
    }

    public Libro getLibro(Long id){
        return libroRepository.getReferenceById(id);
    }


    public List<Libro> buscarLibros(String criterio) {
        LibroValidator.validarCriterioBusqueda(criterio);
        return buscadorLibro.buscar(criterio);
    }
}