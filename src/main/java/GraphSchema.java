import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import static graphql.schema.GraphQLObjectType.newObject;
@Data
@AllArgsConstructor
public class GraphSchema {
    private graphql.schema.GraphQLSchema schema;

    public  GraphSchema() {
        InitOutputType initOutputType = new InitOutputType();
        QueryOneOrMore queryOneOrMore = new QueryOneOrMore();
        schema = graphql.schema.GraphQLSchema.newSchema().query(newObject()
                .name("GraphQuery")
                .field(queryOneOrMore.createUsersField())
                .field(queryOneOrMore.createUserField())
                .build()).build();

    }
}
