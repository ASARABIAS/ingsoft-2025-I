package com.example.demo_builder.domain.builder;

import com.example.demo_builder.domain.SQLQuery;

public interface QueryBuilder {
    QueryBuilder select(String... columns);
    QueryBuilder from(String table);
    QueryBuilder where(String condition, Object... params);
    QueryBuilder join(String joinClause);
    QueryBuilder leftJoin(String joinClause);
    QueryBuilder rightJoin(String joinClause);
    QueryBuilder groupBy(String columns);
    QueryBuilder having(String condition);
    QueryBuilder orderBy(String columns);
    QueryBuilder limit(int limit);
    QueryBuilder offset(int offset);
    SQLQuery build();
    void reset();
}
