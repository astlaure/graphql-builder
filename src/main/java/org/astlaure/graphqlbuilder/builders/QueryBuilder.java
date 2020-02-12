package org.astlaure.graphqlbuilder.builders;

import org.astlaure.graphqlbuilder.models.Argument;
import org.astlaure.graphqlbuilder.models.Property;
import org.astlaure.graphqlbuilder.models.Query;
import org.astlaure.graphqlbuilder.utils.QueryBuilderUtils;

import java.util.List;

public class QueryBuilder {
    private String name;

    private ArgumentBuilder argumentBuilder;
    private PropertyBuilder propertyBuilder;

    private QueryBuilder() {
        this.argumentBuilder = ArgumentBuilder.builder(this);
        this.propertyBuilder = PropertyBuilder.builder(this);
    }

    public static QueryBuilder builder() {
        return new QueryBuilder();
    }

    public QueryBuilder name(String name) {
        this.name = name;
        return this;
    }

    public ArgumentBuilder arguments() {
        return this.argumentBuilder;
    }

    public PropertyBuilder properties() {
        return this.propertyBuilder;
    }

    public Query build() {
        StringBuilder builder = new StringBuilder();

        builder.append("{ ")
                .append(this.name);

        List<Argument> arguments = this.argumentBuilder.build();
        List<Property> properties = this.propertyBuilder.build();

        if (arguments.size() > 0) {
            builder.append("(")
                    .append(QueryBuilderUtils.appendArguments(arguments))
                    .append(")");
        }

        if (properties.size() > 0) {
            builder.append(" { ")
                    .append(QueryBuilderUtils.appendProperties(properties))
                    .append(" }");
        }

        builder.append(" }");

        return new Query(builder.toString());
    }
}
