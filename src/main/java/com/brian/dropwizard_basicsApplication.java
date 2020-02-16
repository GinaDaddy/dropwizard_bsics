package com.brian;

import org.glassfish.hk2.utilities.binding.AbstractBinder;

import com.brian.resources.GreetingResource;
import com.brian.service.GreetingService;
import com.brian.service.GreetingServiceImpl;

import io.dropwizard.Application;
import io.dropwizard.jersey.setup.JerseyEnvironment;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

public class dropwizard_basicsApplication extends Application<dropwizard_basicsConfiguration> {

    public static void main(final String[] args) throws Exception {
        new dropwizard_basicsApplication().run(args);
    }

    @Override
    public String getName() {
        return "dropwizard_basics";
    }

    @Override
    public void initialize(final Bootstrap<dropwizard_basicsConfiguration> bootstrap) {
    }

    @Override
    public void run(final dropwizard_basicsConfiguration configuration,
                    final Environment environment) {
        JerseyEnvironment jersey = environment.jersey();
        jersey.register(new AbstractBinder() {
            @Override
            protected void configure() {
                bind(GreetingServiceImpl.class).to(GreetingService.class);
            }
        });
        jersey.register(GreetingResource.class);

    }

}
