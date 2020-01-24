package org.astlaure.graphqlbuilder.models;

import java.util.List;

public class GraphQLArgument {
    private String name;
    private Object value;

    public GraphQLArgument(String name, String value) {
        this.name = name;
        this.value = value;
    }

    public GraphQLArgument(String name, boolean value) {
        this.name = name;
        this.value = value;
    }

    public GraphQLArgument(String name, int value) {
        this.name = name;
        this.value = value;
    }

    public GraphQLArgument(String name, float value) {
        this.name = name;
        this.value = value;
    }

    public GraphQLArgument(String name, List<GraphQLArgument> value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public Object getValue() {
        return value;
    }
}
