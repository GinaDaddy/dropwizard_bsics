package com.brian;

import io.dropwizard.Configuration;

import com.brian.core.MessageQueueFactory;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.validator.constraints.*;

import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * https://www.dropwizard.io/en/stable/manual/core.html
 * STEP 3. Have a independent configuration class MessageQueueFactory as a field and instantiate it using setMessageQueue() by Jackson
 */
public class dropwizard_basicsConfiguration extends Configuration {
    @Valid
    @NotNull
    private MessageQueueFactory messageQueue = new MessageQueueFactory();

    @JsonProperty("messageQueue")
    public MessageQueueFactory getMessageQueue() {
        return messageQueue;
    }

    // STEP 3. MessageQueueFactory is filled from yml with the field messageQueue.
    // MessageQueueFactory's host and port are set by Jackson
    @JsonProperty("messageQueue")
    public void setMessageQueue(MessageQueueFactory messageQueue) {
        this.messageQueue = messageQueue;
    }
}
