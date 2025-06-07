package com.biblioteca.repository;

import com.biblioteca.model.Libro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface LibroRepository extends JpaRepository<Libro, Long> {

    // Métodos básicos de búsqueda
    List<Libro> findByTituloContaining(String titulo);
    List<Libro> findByAutorContaining(String autor);
    List<Libro> findByIsbn(String isbn);
    List<Libro> findByCategoria(String categoria);

    // VIOLACIÓN ISP: Métodos específicos que no todos los clientes necesitan
    @Query("SELECT l FROM Libro l WHERE l.copiasDisponibles > 0")
    List<Libro> findLibrosDisponibles();

    @Query("SELECT l FROM Libro l WHERE l.categoria = 'REFERENCIA'")
    List<Libro> findLibrosReferencia();

    @Query("SELECT l FROM Libro l WHERE l.categoria = 'ESPECIAL'")
    List<Libro> findLibrosEspeciales();

    // Métodos de reporte (VIOLACIÓN SRP del repositorio)
    @Query("SELECT COUNT(l) FROM Libro l WHERE l.categoria = ?1")
    Long contarLibrosPorCategoria(String categoria);

    @Query("SELECT l.categoria, COUNT(l) FROM Libro l GROUP BY l.categoria")
    List<Object[]> obtenerEstadisticasPorCategoria();

    // Métodos de negocio (VIOLACIÓN: repositorio con lógica de negocio)
    @Query("SELECT l FROM Libro l WHERE l.copiasDisponibles < 2")
    List<Libro> findLibrosConPocasCopiasDisponibles();
}
