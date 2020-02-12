package org.astlaure.graphqlbuilder.builders;

import org.astlaure.graphqlbuilder.models.Argument;

import java.util.ArrayList;
import java.util.List;

public class ArgumentBuilder {
    private List<Argument> arguments = new ArrayList<>();

    private String name = null;
    private ArgumentBuilder parent = null;
    private static QueryBuilder root = null;

    private ArgumentBuilder() {}

    private ArgumentBuilder(String name, ArgumentBuilder parent) {
        this.name = name;
        this.parent = parent;
    }

    public static ArgumentBuilder builder() {
        return new ArgumentBuilder();
    }

    public static ArgumentBuilder builder(QueryBuilder builder) {
        root = builder;
        return new ArgumentBuilder();
    }

    public ArgumentBuilder addArgument(String name, String argument) {
        this.arguments.add(new Argument(name, argument));
        return this;
    }

    public ArgumentBuilder addArgument(String name, int argument) {
        this.arguments.add(new Argument(name, argument));
        return this;
    }

    public ArgumentBuilder addArgument(String name, float argument) {
        this.arguments.add(new Argument(name, argument));
        return this;
    }

    public ArgumentBuilder addArgument(String name, boolean argument) {
        this.arguments.add(new Argument(name, argument));
        return this;
    }

    public ArgumentBuilder addNestedArgument(String name) {
        return new ArgumentBuilder(name, this);
    }

    public ArgumentBuilder next() {
        this.parent.arguments.add(new Argument(this.name, this.arguments));
        return parent;
    }

    public QueryBuilder end() {
        return root;
    }

    public List<Argument> build() {
        return this.arguments;
    }
}
