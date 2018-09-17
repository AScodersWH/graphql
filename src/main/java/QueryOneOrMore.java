import graphql.schema.GraphQLFieldDefinition;
import graphql.schema.GraphQLList;

import java.util.ArrayList;
import java.util.List;

import static graphql.Scalars.GraphQLInt;
import static graphql.Scalars.GraphQLString;
import static graphql.schema.GraphQLArgument.newArgument;
import static graphql.schema.GraphQLFieldDefinition.newFieldDefinition;

public class QueryOneOrMore {
    public GraphQLFieldDefinition createUserField() {
        InitOutputType initOut = new InitOutputType();
        return newFieldDefinition()
                .name("user")
                .argument(newArgument().name("id").type(GraphQLInt).build())
                .type(initOut.getUserType())
                .dataFetcher(environment -> {
                    // 获取查询参数
                    int id = environment.getArgument("id");

                    // 执行查询, 这里随便用一些测试数据来说明问题
                    User user = new User();
                    user.setId(id);
                    user.setAge(id + 15);
                    user.setSex(id % 2);
                    user.setName("Name_" + id);
                    user.setPic("pic_" + id + ".jpg");
                    return user;
                })
                .build();
    }

    /**
     * 查询多个会员信息
     * @return
     */
    public GraphQLFieldDefinition createUsersField() {
        InitOutputType initOut = new InitOutputType();

        return newFieldDefinition()
                .name("users")
                .argument(newArgument().name("page").type(GraphQLInt).build())
                .argument(newArgument().name("size").type(GraphQLInt).build())
                .argument(newArgument().name("name").type(GraphQLString).build())
                .type(new GraphQLList(initOut.getUserType()))
                .dataFetcher(environment -> {
                    // 获取查询参数
                    int page = environment.getArgument("page");
                    int size = environment.getArgument("size");
                    String name = environment.getArgument("name");

                    // 执行查询, 这里随便用一些测试数据来说明问题
                    List<User> list = new ArrayList<>(size);
                    for (int i = 0; i < size; i++) {
                        User user = new User();
                        user.setId(i);
                        user.setAge(i + 15);
                        user.setSex(i % 2);
                        user.setName(name + "_" + page + "_" + i);
                        user.setPic("pic_" + i + ".jpg");
                        list.add(user);
                    }
                    return list;
                })
                .build();
    }
}
