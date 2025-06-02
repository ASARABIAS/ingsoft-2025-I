package com.example.demo_builder.controller;

import com.example.demo_builder.domain.entity.Usuario;
import com.example.demo_builder.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping("/activos")
    public ResponseEntity<List<Usuario>> obtenerUsuariosActivos() {
        List<Usuario> usuarios = usuarioService.obtenerUsuariosActivos();
        return ResponseEntity.ok(usuarios);
    }

    @GetMapping("/por-edad")
    public ResponseEntity<List<Usuario>> obtenerUsuariosPorEdad(
            @RequestParam int edadMin,
            @RequestParam int edadMax) {
        List<Usuario> usuarios = usuarioService.obtenerUsuariosPorEdad(edadMin, edadMax);
        return ResponseEntity.ok(usuarios);
    }

    @GetMapping("/estadisticas-edad")
    public ResponseEntity<List<Object[]>> obtenerEstadisticasEdad() {
        List<Object[]> estadisticas = usuarioService.obtenerConteoUsuariosPorGrupoEdad();
        return ResponseEntity.ok(estadisticas);
    }

    @GetMapping("/paginados")
    public ResponseEntity<List<Usuario>> obtenerUsuariosPaginados(
            @RequestParam(defaultValue = "0") int pagina,
            @RequestParam(defaultValue = "10") int tamaño) {
        List<Usuario> usuarios = usuarioService.obtenerUsuariosPaginados(pagina, tamaño);
        return ResponseEntity.ok(usuarios);
    }
}
