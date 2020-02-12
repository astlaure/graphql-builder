package org.astlaure.graphqlbuilder.models;

import java.util.Map;

public class Query {
    private String query;
    private String operationName;
    private Map<String, Object> variables;

    public Query(String query) {
        this.query = query;
    }

    public String getQuery() {
        return query;
    }

    public String getOperationName() {
        return operationName;
    }

    public Map<String, Object> getVariables() {
        return variables;
    }
}
