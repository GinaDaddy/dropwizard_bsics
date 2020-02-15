package com.brian.resources;

import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.brian.api.Saying;
import com.codahale.metrics.annotation.Timed;

/**
 * STEP 5: create a resource class. Each resource class is associated with a URI template.
 * After creating a resource class, it should be registered to HelloWorldApplication.
 * That means that this HelloWorldResource will be instantiated by the HelloWorldApplication run(). Look STEP 6.
 *
 * For our application, we need a resource which returns new Saying instances from the URI /hello-world, so our resource class looks like this:
 * An AtomicLong provides us with a cheap, thread-safe way of generating unique(ish) IDs.
 * Because sayHello is annotated with @Timed, Dropwizard automatically records the duration and rate of its invocations as a Metrics Timer.
 */

@Path("/hello-world")
@Produces(MediaType.APPLICATION_JSON)
public class HelloWorldResource {
    private final String template;
    private final String defaultName;
    private final AtomicLong counter;

    public HelloWorldResource(String template, String defaultName) {
        this.template = template;
        this.defaultName = defaultName;
        this.counter = new AtomicLong();
    }

    @GET
    @Timed
    public Saying sayHello(@QueryParam("name") Optional<String> name) {
        final String value = String.format(template, name.orElse(defaultName));
        return new Saying(counter.incrementAndGet(), value);
    }
}
