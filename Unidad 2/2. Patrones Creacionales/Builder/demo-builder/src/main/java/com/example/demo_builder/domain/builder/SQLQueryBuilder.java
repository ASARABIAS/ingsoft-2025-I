package com.example.demo_builder.domain.builder;
import org.springframework.stereotype.Component;
import com.example.demo_builder.domain.SQLQuery;

@Component
public class SQLQueryBuilder implements QueryBuilder {
    private SQLQuery query;

    public SQLQueryBuilder() {
        this.query = new SQLQuery();
    }

    @Override
    public QueryBuilder select(String... columns) {
        if (columns.length == 0) {
            query.setSelectClause("SELECT *");
        } else {
            System.out.println("SELECT " + String.join(", ", columns));
            query.setSelectClause("SELECT " + String.join(", ", columns));
        }
        return this;
    }

    @Override
    public QueryBuilder from(String table) {
        query.setFromClause("FROM " + table);
        return this;
    }

    @Override
    public QueryBuilder where(String condition, Object... params) {
        query.getWhereClauses().add(condition);
        for (Object param : params) {
            query.getParameters().add(param);
        }
        return this;
    }

    @Override
    public QueryBuilder join(String joinClause) {
        query.getJoinClauses().add("INNER JOIN " + joinClause);
        return this;
    }

    @Override
    public QueryBuilder leftJoin(String joinClause) {
        query.getJoinClauses().add("LEFT JOIN " + joinClause);
        return this;
    }

    @Override
    public QueryBuilder rightJoin(String joinClause) {
        query.getJoinClauses().add("RIGHT JOIN " + joinClause);
        return this;
    }

    @Override
    public QueryBuilder groupBy(String columns) {
        query.setGroupByClause("GROUP BY " + columns);
        return this;
    }

    @Override
    public QueryBuilder having(String condition) {
        query.setHavingClause("HAVING " + condition);
        return this;
    }

    @Override
    public QueryBuilder orderBy(String columns) {
        query.setOrderByClause("ORDER BY " + columns);
        return this;
    }

    @Override
    public QueryBuilder limit(int limit) {
        query.setLimitClause("LIMIT " + limit);
        return this;
    }

    @Override
    public QueryBuilder offset(int offset) {
        String currentLimit = query.getLimitClause();
        if (currentLimit != null) {
            query.setLimitClause(currentLimit + " OFFSET " + offset);
        } else {
            query.setLimitClause("OFFSET " + offset);
        }
        return this;
    }

    @Override
    public SQLQuery build() {
        SQLQuery result = this.query;
        reset();
        return result;
    }

    @Override
    public void reset() {
        this.query = new SQLQuery();
    }
}
