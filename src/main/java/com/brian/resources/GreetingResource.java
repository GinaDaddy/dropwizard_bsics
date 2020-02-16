package com.brian.resources;

import java.util.Optional;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.brian.api.Greeting;
import com.brian.service.GreetingService;

@Path("/greetings")
@Produces(MediaType.APPLICATION_JSON)
public class GreetingResource {

    private final GreetingService greetingService;

    @Inject
    public GreetingResource(GreetingService greetingService) {
        this.greetingService = greetingService;
    }

    @GET
    public Greeting greet(@QueryParam("name") Optional<String> name) {

        return new Greeting(greetingService.greeting());
    }
}
