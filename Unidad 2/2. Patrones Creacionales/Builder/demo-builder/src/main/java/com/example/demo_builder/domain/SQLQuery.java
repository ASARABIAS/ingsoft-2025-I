package com.example.demo_builder.domain;

import com.example.demo_builder.domain.builder.QueryBuilder;
import lombok.Data;
import java.util.ArrayList;
import java.util.List;

@Data
public class SQLQuery {
    private String selectClause;
    private String fromClause;
    private List<String> whereClauses;
    private List<String> joinClauses;
    private String groupByClause;
    private String havingClause;
    private String orderByClause;
    private String limitClause;
    private List<Object> parameters;

    public SQLQuery() {
        this.whereClauses = new ArrayList<>();
        this.joinClauses = new ArrayList<>();
        this.parameters = new ArrayList<>();
    }

    public SQLQuery(String selectClause, String fromClause, List<String> whereClauses, List<String> joinClauses, String groupByClause, String havingClause, String orderByClause, String limitClause, List<Object> parameters) {
        this.selectClause = selectClause;
        this.fromClause = fromClause;
        this.whereClauses = whereClauses;
        this.joinClauses = joinClauses;
        this.groupByClause = groupByClause;
        this.havingClause = havingClause;
        this.orderByClause = orderByClause;
        this.limitClause = limitClause;
        this.parameters = parameters;
    }

    public String buildQuery() {
        StringBuilder query = new StringBuilder();

        // SELECT
        if (selectClause != null) {
            query.append(selectClause);
        }

        // FROM
        if (fromClause != null) {
            query.append(" ").append(fromClause);
        }

        // JOINs
        for (String join : joinClauses) {
            query.append(" ").append(join);
        }

        // WHERE
        if (!whereClauses.isEmpty()) {
            query.append(" WHERE ");
            query.append(String.join(" AND ", whereClauses));
        }

        // GROUP BY
        if (groupByClause != null) {
            query.append(" ").append(groupByClause);
        }

        // HAVING
        if (havingClause != null) {
            query.append(" ").append(havingClause);
        }

        // ORDER BY
        if (orderByClause != null) {
            query.append(" ").append(orderByClause);
        }

        // LIMIT
        if (limitClause != null) {
            query.append(" ").append(limitClause);
        }

        return query.toString().trim();
    }
}
