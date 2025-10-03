package org.acme;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.HeaderParam;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import org.apache.camel.ProducerTemplate;

@Path("/auth")
public class AuthResource {

    @Inject
    ProducerTemplate producerTemplate;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello(@HeaderParam("Authorization") String authorization) {
        if (authorization == null) {
            return "No authorization header";
        }
        
        String response = producerTemplate.requestBodyAndHeader(
            "https://webhook.site/f9a371a4-944d-43f8-83ee-e058d0615f89",
            null,
            "Authorization",
            authorization,
            String.class
        );
        
        return response;
    }
}
