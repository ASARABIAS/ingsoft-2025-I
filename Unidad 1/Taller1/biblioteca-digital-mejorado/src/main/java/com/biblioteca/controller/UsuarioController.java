package com.biblioteca.controller;

import com.biblioteca.model.Usuario;
import com.biblioteca.service.BibliotecaService;
import com.biblioteca.dto.UsuarioDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.logging.Logger;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {
    private static final Logger logger = Logger.getLogger(UsuarioController.class.getName());

    @Autowired
    private BibliotecaService bibliotecaService;

    @PostMapping
    public ResponseEntity<Usuario> registrarUsuario(@RequestBody UsuarioDTO usuarioDTO) {
        // VIOLACIÓN: Validación en controller
        if (!validarEmailFormato(usuarioDTO.getEmail())) {
            return ResponseEntity.badRequest().build();
        }

        // Conversión manual (VIOLACIÓN DIP)
        Usuario usuario = convertirDTOaEntity(usuarioDTO);
        Usuario usuarioRegistrado = bibliotecaService.registrarUsuario(usuario);

        return ResponseEntity.ok(usuarioRegistrado);
    }

    @GetMapping("/{id}/reporte")
    public ResponseEntity<String> generarReporte(@PathVariable Long id) {
        // VIOLACIÓN SRP: Controller genera reportes
        String reporte = bibliotecaService.generarReporteUsuario(id);
        return ResponseEntity.ok(reporte);
    }

    // VIOLACIÓN SRP: Controller hace validaciones
    private boolean validarEmailFormato(String email) {
        return email != null && email.contains("@");
    }

    // VIOLACIÓN DIP: Conversión manual sin abstracción
    private Usuario convertirDTOaEntity(UsuarioDTO dto) {
        Usuario usuario = new Usuario();
        usuario.setNombre(dto.getNombre());
        usuario.setEmail(dto.getEmail());
        usuario.setTelefono(dto.getTelefono());
        usuario.setDireccion(dto.getDireccion());
        usuario.setTipoUsuario(dto.getTipoUsuario());
        return usuario;
    }
}