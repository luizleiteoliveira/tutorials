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
    public String auth(String authorization) {
        if (authorization == null) {
            return "No authorization token";
        }

        return producerTemplate.requestBodyAndHeader(
            "direct:webhook",
            null,
            "Authorization",
            authorization,
            String.class
        );
    }
}
