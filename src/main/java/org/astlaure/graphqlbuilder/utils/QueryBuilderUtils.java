package org.astlaure.graphqlbuilder.utils;

import org.astlaure.graphqlbuilder.models.Argument;
import org.astlaure.graphqlbuilder.models.Property;

import java.util.List;

public class QueryBuilderUtils {

    public static String appendArguments(List<Argument> arguments) {
        StringBuilder builder = new StringBuilder();

        for (Argument argument: arguments
        ) {
            if (argument.getArgument() instanceof String) {
                builder.append(argument.getName())
                        .append(": \"")
                        .append(argument.getArgument().toString())
                        .append("\"");
            } else if (argument.getArgument() instanceof List) {
                builder.append(argument.getName())
                        .append(": { ")
                        .append(appendArguments((List<Argument>) argument.getArgument()))
                        .append(" }");
            } else {
                builder.append(argument.getName())
                        .append(": ")
                        .append(argument.getArgument().toString());
            }
            builder.append(", ");
        }
        builder.delete(builder.length() - 2, builder.length());

        return builder.toString();
    }

    public static String appendProperties(List<Property> properties) {
        StringBuilder builder = new StringBuilder();

        for (Property property: properties
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
