package org.astlaure.graphqlbuilder.utils;

import org.astlaure.graphqlbuilder.models.Argument;
import org.astlaure.graphqlbuilder.models.Property;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class QueryBuilderUtilsTest {

    @Test
    public void testAppendPropertiesOnlyKeys() {
        List<Property> properties = new ArrayList<>();

        properties.add(new Property("firstName", null));
        properties.add(new Property("lastName", null));

        String result = QueryBuilderUtils.appendProperties(properties);

        assertThat(result)
                .isEqualTo("firstName, lastName");
    }

    @Test
    public void testAppendPropertiesMixed() {
        List<Property> properties = new ArrayList<>();

        properties.add(new Property("firstName", null));
        properties.add(new Property("lastName", null));
        properties.add(new Property("documents", Arrays.asList(
                new Property("id", null),
                new Property("title", null)
        )));
        properties.add(new Property("isActive", null));

        String result = QueryBuilderUtils.appendProperties(properties);

        assertThat(result)
                .isEqualTo("firstName, lastName, documents { id, title }, isActive");
    }

    @Test
    public void testAppendArgumentsOnlyKeys() {
        List<Argument> arguments = new ArrayList<>();

        arguments.add(new Argument("firstName", "Toto"));
        arguments.add(new Argument("lastName", "Africa"));
        arguments.add(new Argument("age", 25));
        arguments.add(new Argument("isGood", true));
        arguments.add(new Argument("price", 19.99f));

        String result = QueryBuilderUtils.appendArguments(arguments);

        assertThat(result)
                .isEqualTo("firstName: \"Toto\", lastName: \"Africa\", age: 25, isGood: true, price: 19.99");
    }

    @Test
    public void testAppendArgumentsMixed() {
        List<Argument> arguments = new ArrayList<>();

        arguments.add(new Argument("firstName", "Toto"));
        arguments.add(new Argument("lastName", "Africa"));
        arguments.add(new Argument("documents", Arrays.asList(
                new Argument("id", 1),
                new Argument("title", "Hello World")
        )));

        String result = QueryBuilderUtils.appendArguments(arguments);

        assertThat(result)
                .isEqualTo("firstName: \"Toto\", lastName: \"Africa\", documents: { id: 1, title: \"Hello World\" }");
    }
}
