package org.astlaure.graphqlbuilder.builders;

import org.astlaure.graphqlbuilder.models.Property;

import java.util.ArrayList;
import java.util.List;

public class PropertyBuilder {
    private List<Property> properties = new ArrayList<>();

    private String name = null;
    private PropertyBuilder parent = null;
    private static QueryBuilder root = null;

    private PropertyBuilder() {}

    private PropertyBuilder(String name, PropertyBuilder parent) {
        this.name = name;
        this.parent = parent;
    }

    public static PropertyBuilder builder() {
        return new PropertyBuilder();
    }

    public static PropertyBuilder builder(QueryBuilder builder) {
        root = builder;
        return new PropertyBuilder();
    }

    public PropertyBuilder addProperty(String name) {
        this.properties.add(new Property(name));
        return this;
    }

    public PropertyBuilder addNestedProperty(String name) {
        return new PropertyBuilder(name, this);
    }

    public PropertyBuilder next() {
        this.parent.properties.add(new Property(this.name, this.properties));
        return parent;
    }

    public QueryBuilder end() {
        return root;
    }

    public List<Property> build() {
        return this.properties;
    }
}
