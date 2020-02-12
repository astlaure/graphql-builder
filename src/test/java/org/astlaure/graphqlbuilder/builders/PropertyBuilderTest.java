package org.astlaure.graphqlbuilder.builders;

import org.assertj.core.api.Assertions;
import org.astlaure.graphqlbuilder.models.Property;
import org.junit.jupiter.api.Test;

import java.util.List;

public class PropertyBuilderTest {

    @Test
    void testComplexProperties() {
        List<Property> props = PropertyBuilder.builder()
                .addProperty("firstName")
                .addNestedProperty("account")
                    .addProperty("username")
                    .addProperty("password")
                    .next()
                .addProperty("lastName")
                .build();

        Assertions.assertThat(props.size())
                .isEqualTo(3);
    }
}
