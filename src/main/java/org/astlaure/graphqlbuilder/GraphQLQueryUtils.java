package org.astlaure.graphqlbuilder;

import org.astlaure.graphqlbuilder.models.GraphQLArgument;
import org.astlaure.graphqlbuilder.models.GraphQLProperty;

import java.util.List;

public class GraphQLQueryUtils {

    public static String appendArguments(List<GraphQLArgument> arguments) {
        StringBuilder builder = new StringBuilder();

        for (GraphQLArgument argument: arguments
        ) {
            if (argument.getValue() instanceof String) {
                builder.append(argument.getName())
                        .append(": \"")
                        .append(argument.getValue().toString())
                        .append("\"");
            } else if (argument.getValue() instanceof List) {
                builder.append(argument.getName())
                        .append(": { ")
                        .append(appendArguments((List<GraphQLArgument>) argument.getValue()))
                        .append(" }");
            } else {
                builder.append(argument.getName())
                        .append(": ")
                        .append(argument.getValue().toString());
            }
            builder.append(", ");
        }
        builder.delete(builder.length() - 2, builder.length());

        return builder.toString();
    }

    public static String appendProperties(List<GraphQLProperty> properties) {
        StringBuilder builder = new StringBuilder();

        for (GraphQLProperty property: properties
        ) {
            if (property.getProperties() == null) {
                builder.append(property.getName());
            } else {
                builder.append(property.getName())
                        .append(" { ")
                        .append(appendProperties(property.getProperties()))
                        .append(" }");
            }
            builder.append(", ");
        }
        builder.delete(builder.length() - 2, builder.length());

        return builder.toString();
    }
}
