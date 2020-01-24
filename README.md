# GraphQL Builder

### Why

This project was created to be make the calls between Java APIs\
(mostly Spring Boot) with GraphQL painless.

Instead of waiting for JDK 13 and have access to the multilines strings\
I created this builder to create the string for us.

How to build a Query:

```java
List<GraphQLArgument> arguments = Collections.singletonList(
        new GraphQLArgument("clientID", 1)
);

List<GraphQLProperty> properties = Arrays.asList(
        new GraphQLProperty("firstName"),
        new GraphQLProperty("lastName")
);

GraphQLQuery query = GraphQLQueryBuilder.buildQuery("getClient", arguments, properties);
```

Nested Object:

```java
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
```

Complete example for a call:

```java
RestTemplate template = new RestTemplate();

List<GraphQLArgument> arguments = Collections.singletonList(
        new GraphQLArgument("clientID", 1)
);

List<GraphQLProperty> properties = Arrays.asList(
        new GraphQLProperty("firstName"),
        new GraphQLProperty("lastName")
);

GraphQLQuery query = GraphQLQueryBuilder.buildQuery("getClient", arguments, properties);

return template.postForEntity("http://localhost:8080/graphql", query, Object.class);
```

### Still Missing

1. OperationName
2. Variables