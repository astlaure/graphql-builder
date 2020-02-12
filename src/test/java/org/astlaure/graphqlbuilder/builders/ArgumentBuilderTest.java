package org.astlaure.graphqlbuilder.builders;

import org.assertj.core.api.Assertions;
import org.astlaure.graphqlbuilder.models.Argument;
import org.junit.jupiter.api.Test;

import java.util.List;

public class ArgumentBuilderTest {

    @Test
    void createComplexArguments() {
        List<Argument> args = ArgumentBuilder.builder()
                .addArgument("id", 1)
                .addNestedArgument("Profile")
                    .addArgument("firstName", "Toto")
                    .addArgument("lastName", "Africa")
                    .next()
                .addArgument("isAvailable", true)
                .addArgument("price", 19.99f)
                .addArgument("title", "Toto Africa")
                .build();

        Assertions.assertThat(args.size())
                .isEqualTo(5);
    }
}
