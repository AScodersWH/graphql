package com.thoughtworks.test.tomwang.service;

import graphql.schema.GraphQLOutputType;
import lombok.Data;
import org.springframework.stereotype.Service;

import static graphql.Scalars.GraphQLInt;
import static graphql.Scalars.GraphQLString;
import static graphql.schema.GraphQLFieldDefinition.newFieldDefinition;
import static graphql.schema.GraphQLObjectType.newObject;
@Data
@Service
public class InitOutputType {
    private GraphQLOutputType userType;

    public InitOutputType() {

        userType = newObject()
                .name("User")
                .field(newFieldDefinition().name("id").type(GraphQLInt).build())
                .field(newFieldDefinition().name("userName").type(GraphQLString).build())
                .field(newFieldDefinition().name("passWord").type(GraphQLString).build())
                .field(newFieldDefinition().name("phone").type(GraphQLString).build())
                .field(newFieldDefinition().name("mail").type(GraphQLString).build())
                .build();
    }
}
