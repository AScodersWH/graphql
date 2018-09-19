package com.thoughtworks.test.tomwang.service.graphql;


import com.thoughtworks.test.tomwang.model.User;
import com.thoughtworks.test.tomwang.repository.UserRepository;
import graphql.GraphQL;
import graphql.schema.GraphQLFieldDefinition;
import graphql.schema.GraphQLSchema;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

import static graphql.Scalars.GraphQLInt;
import static graphql.schema.GraphQLArgument.newArgument;
import static graphql.schema.GraphQLObjectType.newObject;
@Service
public class GraphqlService {
    @Autowired
    UserRepository userRepository;

    private GraphQLSchema schema;

    public  Map<String, Object> graphqlss(String userId){
       GraphSchema();


//        String query1 = "{users(page:2,size:5,name:\"john\") {id,sex,name,pic}}";
        String query2 = "{user(id:"+userId+"){id}}";
        System.out.println(userId);
//        String query3 = "{user(id:6) {id,sex,name,pic},users(page:2,size:5,name:\"john\") {id,sex,name,pic}}";

//        Map<String, Object> result1 = (Map<String, Object>) new GraphQL(schema).execute(query1).getData();
        Map<String, Object> result2 = (Map<String, Object>) new GraphQL(schema).execute(query2).getData();
//        Map<String, Object> result3 = (Map<String, Object>) new GraphQL(schema).execute(query3).getData();

        // 查询用户列表
//        System.out.println(result1);
        // 查询单个用户
        System.out.println(result2);
        return result2;
        // 单个用户、跟用户列表一起查
//        System.out.println(result3);

    }


    public GraphQLFieldDefinition createUserField() {

        return GraphQLFieldDefinition.newFieldDefinition()
                .name("user")
                .argument(newArgument().name("id").type(GraphQLInt).build())
                .type(new InitOutputType().getUserType())
                .dataFetcher(environment -> {
                    // 获取查询参数
                    int id = environment.getArgument("id");
                    User user = userRepository.findOneById(id);

                    return user;
                })
                .build();
    }


    public void GraphSchema() {
        schema = GraphQLSchema.newSchema().query(newObject()
                .name("GraphQuery")
//                .field(queryService.createUsersField())
                .field(createUserField())
                .build()).build();
    }
}