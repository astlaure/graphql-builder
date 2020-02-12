package org.astlaure.graphqlbuilder.models;

public class Argument {
    private String name;
    private Object argument;

    public Argument(String name, Object argument) {
        this.name = name;
        this.argument = argument;
    }

    public String getName() {
        return name;
    }

    public Object getArgument() {
        return argument;
    }
}
