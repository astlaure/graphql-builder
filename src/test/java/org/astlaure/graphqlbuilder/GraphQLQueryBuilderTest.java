package org.astlaure.graphqlbuilder;

import org.astlaure.graphqlbuilder.models.GraphQLArgument;
import org.astlaure.graphqlbuilder.models.GraphQLProperty;
import org.astlaure.graphqlbuilder.models.GraphQLQuery;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class GraphQLQueryBuilderTest {

    @Test
    public void testQueryBuilderFullQuery() {
        List<GraphQLArgument> arguments = Collections.singletonList(
                new GraphQLArgument("clientID", 1)
        );

        List<GraphQLProperty> properties = Arrays.asList(
                new GraphQLProperty("firstName"),
                new GraphQLProperty("lastName")
        );

        GraphQLQuery query = GraphQLQueryBuilder.buildQuery("getClient", arguments, properties);

        assertThat(query.getQuery())
                .isEqualTo("{ getClient(clientID: 1) { firstName, lastName } }");
    }

    @Test
    public void testQueryBuilderComplex() {
        List<GraphQLArgument> arguments = Arrays.asList(
                new GraphQLArgument("clientID", 1),
                new GraphQLArgument("profile", Arrays.asList(
                        new GraphQLArgument("firstName", "Toto"),
                        new GraphQLArgument("lastName", "Africa")
                ))
        );

        List<GraphQLProperty> properties = Arrays.asList(
                new GraphQLProperty("firstName"),
                new GraphQLProperty("lastName"),
                new GraphQLProperty("documents", Arrays.asList(
                        new GraphQLProperty("id"),
                        new GraphQLProperty("title")
                ))
        );

        GraphQLQuery query = GraphQLQueryBuilder.buildQuery("getClient", arguments, properties);

        assertThat(query.getQuery())
                .isEqualTo("{ getClient(clientID: 1, profile: { firstName: \"Toto\", lastName: \"Africa\" }) { firstName, lastName, documents { id, title } } }");
    }

    @Test
    public void testQueryBuilderNoArguments() {
        List<GraphQLProperty> properties = Arrays.asList(
                new GraphQLProperty("firstName"),
                new GraphQLProperty("lastName")
        );

        GraphQLQuery query = GraphQLQueryBuilder.buildQuery("getClient", properties);

        assertThat(query.getQuery())
                .isEqualTo("{ getClient { firstName, lastName } }");
    }
}
