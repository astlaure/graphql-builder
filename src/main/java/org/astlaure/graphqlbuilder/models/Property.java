package org.astlaure.graphqlbuilder.models;

import java.util.List;

public class Property {
    private String name;
    private List<Property> properties;

    public Property(String name) {
        this.name = name;
        this.properties = null;
    }

    public Property(String name, List<Property> properties) {
        this.name = name;
        this.properties = properties;
    }

    public String getName() {
        return name;
    }

    public List<Property> getProperties() {
        return properties;
    }
}
