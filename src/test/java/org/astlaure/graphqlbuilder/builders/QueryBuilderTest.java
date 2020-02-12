package org.astlaure.graphqlbuilder.builders;

import org.astlaure.graphqlbuilder.models.Query;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class QueryBuilderTest {

    @Test
    public void testQueryBuilderFullQuery() {
        Query query = QueryBuilder.builder()
                .name("getClient")
                .arguments()
                .addArgument("clientID", 1)
                .end()
                .properties()
                .addProperty("firstName")
                .addProperty("lastName")
                .end()
                .build();

        assertThat(query.getQuery())
                .isEqualTo("{ getClient(clientID: 1) { firstName, lastName } }");
    }

    @Test
    public void testQueryBuilderComplex() {
        Query query = QueryBuilder.builder()
                .name("getClient")
                .arguments()
                .addArgument("clientID", 1)
                .addNestedArgument("profile")
                .addArgument("firstName", "Toto")
                .addArgument("lastName", "Africa")
                .next()
                .end()
                .properties()
                .addProperty("firstName")
                .addProperty("lastName")
                .addNestedProperty("documents")
                .addProperty("id")
                .addProperty("title")
                .next()
                .end()
                .build();

        assertThat(query.getQuery())
                .isEqualTo("{ getClient(clientID: 1, profile: { firstName: \"Toto\", lastName: \"Africa\" }) { firstName, lastName, documents { id, title } } }");
    }

    @Test
    public void testQueryBuilderNoArguments() {
        Query query = QueryBuilder.builder()
                .name("getClient")
                .properties()
                .addProperty("firstName")
                .addProperty("lastName")
                .end()
                .build();

        assertThat(query.getQuery())
                .isEqualTo("{ getClient { firstName, lastName } }");
    }
}
