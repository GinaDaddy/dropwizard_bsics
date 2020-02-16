package com.brian.service;

public class GreetingServiceImpl implements GreetingService {

    @Override
    public String greeting() {
        return String.format("Hello Brian!");
    }

}
