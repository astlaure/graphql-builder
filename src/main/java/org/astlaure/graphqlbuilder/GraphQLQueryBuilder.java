package org.astlaure.graphqlbuilder;

import org.astlaure.graphqlbuilder.models.GraphQLArgument;
import org.astlaure.graphqlbuilder.models.GraphQLProperty;
import org.astlaure.graphqlbuilder.models.GraphQLQuery;

import java.util.List;

public class GraphQLQueryBuilder {

    public static GraphQLQuery buildQuery(String name,
                                          List<GraphQLProperty> properties) {
        return buildQuery(name, null, properties);
    }

    public static GraphQLQuery buildQuery(String name,
                                          List<GraphQLArgument> arguments,
                                          List<GraphQLProperty> properties) {
        GraphQLQuery graphQLQuery = new GraphQLQuery();
        StringBuilder builder = new StringBuilder();

        builder.append("{ ")
                .append(name);

        if (arguments != null) {
            builder.append("(")
                    .append(GraphQLQueryUtils.appendArguments(arguments))
                    .append(")");
        }

        builder.append(" { ")
                .append(GraphQLQueryUtils.appendProperties(properties))
                .append(" }");

        builder.append(" }");
        graphQLQuery.setQuery(builder.toString());

        return graphQLQuery;
    }
}
