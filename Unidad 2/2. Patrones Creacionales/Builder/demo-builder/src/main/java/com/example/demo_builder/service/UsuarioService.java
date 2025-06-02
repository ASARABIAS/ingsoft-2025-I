package com.example.demo_builder.service;


import com.example.demo_builder.domain.SQLQuery;
import com.example.demo_builder.domain.builder.QueryDirector;
import com.example.demo_builder.domain.entity.Usuario;
import com.example.demo_builder.repository.UsuarioCustomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UsuarioService {

    @Autowired
    private QueryDirector queryDirector;

    @Autowired
    private UsuarioCustomRepository usuarioCustomRepository;

    public List<Usuario> obtenerUsuariosActivos() {
        SQLQuery query = queryDirector.buildActiveUsersQuery();
        return usuarioCustomRepository.executeQuery(query);
    }

    public List<Usuario> obtenerUsuariosPorEdad(int edadMin, int edadMax) {
        SQLQuery query = queryDirector.buildUsersByAgeRangeQuery(edadMin, edadMax);
        return usuarioCustomRepository.executeQuery(query);
    }


    public List<Object[]> obtenerConteoUsuariosPorGrupoEdad() {
        SQLQuery query = queryDirector.buildUserCountByAgeGroupQuery();
        return usuarioCustomRepository.executeQueryForObjects(query);
    }

    public List<Usuario> obtenerUsuariosPaginados(int pagina, int tamaño) {
        SQLQuery query = queryDirector.buildPaginatedUsersQuery(pagina, tamaño);
        return usuarioCustomRepository.executeQuery(query);
    }
}
