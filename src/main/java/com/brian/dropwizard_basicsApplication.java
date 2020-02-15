package com.brian;

import com.brian.core.MessageQueueClient;

import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

/**
 * https://www.dropwizard.io/en/stable/manual/core.html
 * STEP 4. Obtain MessageQueueClient from the (main) configuration using independent configuration class MessageQueueFactory
 */
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
        // TODO: application initialization
    }

    @Override
    public void run(final dropwizard_basicsConfiguration configuration,
                    final Environment environment) {
        MessageQueueClient messageQueue = configuration.getMessageQueue().build(environment);
    }

}
