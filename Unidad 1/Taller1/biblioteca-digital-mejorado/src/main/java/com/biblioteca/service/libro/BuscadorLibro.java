package com.biblioteca.service.libro;

import com.biblioteca.model.Libro;
import com.biblioteca.service.libro.busqueda.EstrategiaBusqueda;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BuscadorLibro {

    @Autowired
    private List<EstrategiaBusqueda> estrategias;

    public List<Libro> buscar(String criterio) {
        for (EstrategiaBusqueda estrategia : estrategias) {
            if (estrategia.soporta(criterio)) {
                return estrategia.buscar(criterio);
            }
        }
        throw new UnsupportedOperationException("Criterio de búsqueda no soportado: " + criterio);
    }
}
