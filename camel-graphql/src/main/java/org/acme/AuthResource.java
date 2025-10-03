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
            "direct:webhook",
            null,
            "Authorization",
            authorization,
            String.class
        );
        
        return response;
    }
}
