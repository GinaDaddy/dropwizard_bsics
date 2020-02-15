package com.brian;

import com.brian.health.TemplateHealthCheck;
import com.brian.resources.HelloWorldResource;

import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

/**
 * STEP 3. create an Application class.
 * Fill out initialize() and run() as needed.
 * For getting started, defaults made by maven are enough, just make sure getName() is what I want. That's it for now.
 *
 * STEP 6. Registering a Resource
 * In STEP 5, we created a HelloWorldResource which has url endpoint. We need to add this new resource class to the application.
 * In its run method we can read the template and default name from the HelloWorldConfiguration instance,
 * create a new HelloWorldResource instance, and then add it to the application’s Jersey environment:
 *
 * STEP 8. Adding a health check
 */
public class HelloWorldApplication extends Application<HelloWorldConfiguration> {

    public static void main(final String[] args) throws Exception {
        new HelloWorldApplication().run(args);
    }

    @Override
    public String getName() {
        // STEP 3
        return "hello-world";
    }

    @Override
    public void initialize(final Bootstrap<HelloWorldConfiguration> bootstrap) {
        // TODO: application initialization
    }

    @Override
    public void run(final HelloWorldConfiguration configuration,
                    final Environment environment) {

        /*
        STEP 6
        When our application starts,
        we create a new instance of our resource class with the parameters from the configuration file and hand it off to the Environment,
        which acts like a registry of all the things your application can do.
         */
        final HelloWorldResource resource = new HelloWorldResource(
            configuration.getTemplate(),
            configuration.getDefaultName()
        );
        environment.jersey().register(resource);

        /*
        STEP 8 Adding a health check
         */
        final TemplateHealthCheck healthCheck = new TemplateHealthCheck(configuration.getTemplate());
        environment.healthChecks().register("template", healthCheck);
    }

}
