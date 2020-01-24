package org.astlaure.graphqlbuilder;

import org.astlaure.graphqlbuilder.models.GraphQLArgument;
import org.astlaure.graphqlbuilder.models.GraphQLProperty;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class GraphQLQueryUtilsTest {

    @Test
    public void testAppendPropertiesOnlyKeys() {
        List<GraphQLProperty> properties = new ArrayList<>();

        properties.add(new GraphQLProperty("firstName", null));
        properties.add(new GraphQLProperty("lastName", null));

        String result = GraphQLQueryUtils.appendProperties(properties);

        assertThat(result)
                .isEqualTo("firstName, lastName");
    }

    @Test
    public void testAppendPropertiesMixed() {
        List<GraphQLProperty> properties = new ArrayList<>();

        properties.add(new GraphQLProperty("firstName", null));
        properties.add(new GraphQLProperty("lastName", null));
        properties.add(new GraphQLProperty("documents", Arrays.asList(
                new GraphQLProperty("id", null),
                new GraphQLProperty("title", null)
        )));
        properties.add(new GraphQLProperty("isActive", null));

        String result = GraphQLQueryUtils.appendProperties(properties);

        assertThat(result)
                .isEqualTo("firstName, lastName, documents { id, title }, isActive");
    }

    @Test
    public void testAppendArgumentsOnlyKeys() {
        List<GraphQLArgument> arguments = new ArrayList<>();

        arguments.add(new GraphQLArgument("firstName", "Toto"));
        arguments.add(new GraphQLArgument("lastName", "Africa"));
        arguments.add(new GraphQLArgument("age", 25));
        arguments.add(new GraphQLArgument("isGood", true));
        arguments.add(new GraphQLArgument("price", 19.99f));

        String result = GraphQLQueryUtils.appendArguments(arguments);

        assertThat(result)
                .isEqualTo("firstName: \"Toto\", lastName: \"Africa\", age: 25, isGood: true, price: 19.99");
    }

    @Test
    public void testAppendArgumentsMixed() {
        List<GraphQLArgument> arguments = new ArrayList<>();

        arguments.add(new GraphQLArgument("firstName", "Toto"));
        arguments.add(new GraphQLArgument("lastName", "Africa"));
        arguments.add(new GraphQLArgument("documents", Arrays.asList(
                new GraphQLArgument("id", 1),
                new GraphQLArgument("title", "Hello World")
        )));

        String result = GraphQLQueryUtils.appendArguments(arguments);

        assertThat(result)
                .isEqualTo("firstName: \"Toto\", lastName: \"Africa\", documents: { id: 1, title: \"Hello World\" }");
    }
}
