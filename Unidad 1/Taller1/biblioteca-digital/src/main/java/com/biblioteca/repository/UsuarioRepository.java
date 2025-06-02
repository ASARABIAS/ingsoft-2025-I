package com.biblioteca.repository;

import com.biblioteca.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    Usuario findByEmail(String email);
    List<Usuario> findByTipoUsuario(String tipoUsuario);
    List<Usuario> findByActivoTrue();

    // VIOLACIÓN: Consultas complejas de negocio en repositorio
    //@Query("SELECT u FROM Usuario u WHERE SIZE(u.prestamos) >= u.limitePrestamos")
    @Query("SELECT u FROM Usuario u WHERE SIZE(u.prestamos) >= 5")
    List<Usuario> findUsuariosConLimiteAlcanzado();

    @Query("SELECT u FROM Usuario u JOIN u.prestamos p WHERE p.estado = 'VENCIDO'")
    List<Usuario> findUsuariosConPrestamosVencidos();
}