package com.brian.api;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Greeting {
    private String saying;

    public Greeting() {
        // Jackson deserialization
    }

    public Greeting(String saying) {
        this.saying = saying;
    }

    @JsonProperty
    public String getSaying() {
        return saying;
    }

    @JsonProperty
    public void setSaying(String saying) {
        this.saying = saying;
    }
}
