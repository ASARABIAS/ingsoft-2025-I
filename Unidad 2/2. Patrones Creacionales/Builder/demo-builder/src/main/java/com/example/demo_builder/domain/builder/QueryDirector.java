package com.example.demo_builder.domain.builder;


import com.example.demo_builder.domain.SQLQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class QueryDirector {

    @Autowired
    private QueryBuilder queryBuilder;

    // Query para obtener usuarios activos
    public SQLQuery buildActiveUsersQuery() {
        return queryBuilder
                .select( )
                .from("usuarios")
                .where(" estado=? ", true)
                .orderBy("nombre ASC")
                .build();
    }

    // Query para obtener usuarios por rango de edad
    public SQLQuery buildUsersByAgeRangeQuery(int minAge, int maxAge) {
        return queryBuilder
                .select("*")
                .from("usuarios")
                .where("edad >= ?", minAge)
                .where("edad <= ?", maxAge)
                .where("estado = ?", true)
                .orderBy("edad DESC")
                .build();
    }

     // Query con agrupación
    public SQLQuery buildUserCountByAgeGroupQuery() {
        return queryBuilder
                .select("CASE WHEN edad < 25 THEN 'Joven' WHEN edad < 50 THEN 'Adulto' ELSE 'Mayor' END as grupo_edad", "COUNT(*) as total")
                .from("usuarios")
                .where("estado = ?", true)
                .groupBy("CASE WHEN edad < 25 THEN 'Joven' WHEN edad < 50 THEN 'Adulto' ELSE 'Mayor' END")
                .having("COUNT(*) > 0")
                .orderBy("total DESC")
                .build();
    }

    // Query paginada
    public SQLQuery buildPaginatedUsersQuery(int page, int size) {
        int offset = page * size;
        return queryBuilder
                .select("*")
                .from("usuarios")
                .where("estado = ?", true)
                .orderBy("id ASC")
                .limit(size)
                .offset(offset)
                .build();
    }
}
