package com.brian.api;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * https://www.dropwizard.io/en/stable/getting-started.html
 * STEP 4. Create a representation class. We will model this JSON representation
 * {
 *     "id": 1,
 *     "content": "Hi!"
 * }
 *
 *This is a pretty simple POJO, but there are a few things worth noting here.
 *
 * First, it’s immutable. This makes Saying instances very easy to reason about in multi-threaded environments as well as single-threaded environments.
 * Second, it uses the JavaBeans standard for the id and content properties.
 * This allows Jackson to serialize it to the JSON we need.
 * The Jackson object mapping code will populate the id field of the JSON object with the return value of #getId(), likewise with content and #getContent().
 */
public class Saying {
    private long id;

    private String content;

    public Saying() {
        // Jackson deserialization
    }

    public Saying(long id, String content) {
        this.id = id;
        this.content = content;
    }

    @JsonProperty
    public long getId() {
        return id;
    }

    @JsonProperty
    public String getContent() {
        return content;
    }
}
