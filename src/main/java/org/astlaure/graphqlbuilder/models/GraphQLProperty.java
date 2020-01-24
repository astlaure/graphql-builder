package org.astlaure.graphqlbuilder.models;

import java.util.List;

/**
 * name: is the name of the property. Most of the time only this field is used
 * properties: represents the nested properties
 */
public class GraphQLProperty {
    private String name;
    private List<GraphQLProperty> properties;

    public GraphQLProperty(String name) {
        this.name = name;
        this.properties = null;
    }

    public GraphQLProperty(String name, List<GraphQLProperty> properties) {
        this.name = name;
        this.properties = properties;
    }

    public String getName() {
        return name;
    }

    public List<GraphQLProperty> getProperties() {
        return properties;
    }
}
