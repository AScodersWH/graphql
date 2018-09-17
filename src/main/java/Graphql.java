import graphql.GraphQL;
import graphql.schema.GraphQLSchema;

import java.util.Map;

public class Graphql {
    public static void main(String[] args) {
        GraphQLSchema schema = new GraphSchema().getSchema();

        String query1 = "{users(page:2,size:5,name:\"john\") {id,sex,name,pic}}";
        String query2 = "{user(id:6){id}}";
        String query3 = "{user(id:6) {id,sex,name,pic},users(page:2,size:5,name:\"john\") {id,sex,name,pic}}";

        Map<String, Object> result1 = (Map<String, Object>) new GraphQL(schema).execute(query1).getData();
        Map<String, Object> result2 = (Map<String, Object>) new GraphQL(schema).execute(query2).getData();
        Map<String, Object> result3 = (Map<String, Object>) new GraphQL(schema).execute(query3).getData();

        // 查询用户列表
        System.out.println(result1);
        // 查询单个用户
        System.out.println(result2);
        // 单个用户、跟用户列表一起查
        System.out.println(result3);

    }
}