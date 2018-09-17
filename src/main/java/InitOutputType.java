import graphql.schema.GraphQLOutputType;
import lombok.Data;

import static graphql.Scalars.GraphQLInt;
import static graphql.Scalars.GraphQLString;
import static graphql.schema.GraphQLFieldDefinition.newFieldDefinition;
import static graphql.schema.GraphQLObjectType.newObject;

@Data
public class InitOutputType {
    private GraphQLOutputType userType;

    public InitOutputType() {

        userType = newObject()
                .name("User")
                .field(newFieldDefinition().name("id").type(GraphQLInt).build())
                .field(newFieldDefinition().name("age").type(GraphQLInt).build())
                .field(newFieldDefinition().name("sex").type(GraphQLInt).build())
                .field(newFieldDefinition().name("name").type(GraphQLString).build())
                .field(newFieldDefinition().name("pic").type(GraphQLString).build())
                .build();
    }
}
