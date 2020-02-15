package com.brian.core;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

import org.hibernate.validator.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.dropwizard.lifecycle.Managed;
import io.dropwizard.setup.Environment;

/**
 * https://www.dropwizard.io/en/stable/manual/core.html
 * STEP 2. Independent configuration class using host and port.
 * This configuration corresponds to "messageQueue" in the config.yml. Look STEP 1.
 * The fields host and port will be set in the main configuration class by Jackson from yml file. Look STEP 3.
 */
public class MessageQueueFactory {
    @NotEmpty
    private String host;

    @Min(1)
    @Max(65535)
    private int port = 5672;

    @JsonProperty
    public String getHost() {
        return host;
    }

    @JsonProperty
    public void setHost(String host) {
        this.host = host;
    }

    @JsonProperty
    public int getPort() {
        return port;
    }

    @JsonProperty
    public void setPort(int port) {
        this.port = port;
    }

    public MessageQueueClient build(Environment environment) {
        MessageQueueClient client = new MessageQueueClient(getHost(), getPort());
        environment.lifecycle().manage(new Managed() {
            @Override
            public void start() throws Exception {
            }

            @Override
            public void stop() throws Exception {
                client.close();
            }
        });
        return client;
    }
}
