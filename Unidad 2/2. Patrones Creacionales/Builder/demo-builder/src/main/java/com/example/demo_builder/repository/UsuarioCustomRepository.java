package com.example.demo_builder.repository;


import com.example.demo_builder.domain.SQLQuery;
import com.example.demo_builder.domain.entity.Usuario;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Repository
public class UsuarioCustomRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @SuppressWarnings("unchecked")
    public List<Usuario> executeQuery(SQLQuery sqlQuery) {
        Query query = entityManager.createNativeQuery(sqlQuery.buildQuery(), Usuario.class);
        List<Object> params = sqlQuery.getParameters();
        for (int i = 0; i < params.size(); i++) {
            query.setParameter(i + 1, params.get(i));
        }

        return query.getResultList();
    }

    @SuppressWarnings("unchecked")
    public List<Object[]> executeQueryForObjects(SQLQuery sqlQuery) {
        Query query = entityManager.createNativeQuery(sqlQuery.buildQuery());

        // Establecer parámetros
        List<Object> params = sqlQuery.getParameters();
        for (int i = 0; i < params.size(); i++) {
            query.setParameter(i + 1, params.get(i));
        }

        return query.getResultList();
    }
}
