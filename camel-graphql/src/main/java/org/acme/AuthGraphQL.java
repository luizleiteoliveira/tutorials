package org.acme;

import jakarta.inject.Inject;
import org.apache.camel.ProducerTemplate;
import org.eclipse.microprofile.graphql.GraphQLApi;
import org.eclipse.microprofile.graphql.Query;

@GraphQLApi
public class AuthGraphQL {

    @Inject
    ProducerTemplate producerTemplate;

    @Query
    public ReturnGraphQL auth(String authorization, String meuNome) {
        if (authorization == null) {
            return null;
        }
        String retorno = producerTemplate.requestBodyAndHeader(
                "direct:webhook",
                null,
                "Authorization",
                authorization,
                String.class
        );
        ReturnGraphQL returnGraphQL = new ReturnGraphQL(meuNome, retorno, authorization, "Bearer");
        return returnGraphQL;
    }
}

