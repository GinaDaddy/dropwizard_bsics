package com.brian.health;

import com.codahale.metrics.health.HealthCheck;

/**
 * STEP 7. Creating a health check, then register it to the environment in the run() in STEP 8
 * who instantiates this? - HelloWorldApplication.run() will instantiate
 */
public class TemplateHealthCheck extends HealthCheck {
    private final String template;

    public TemplateHealthCheck(String template) {
        this.template = template;
    }

    @Override
    protected Result check() throws Exception {
        final String saying = String.format(template, "TEST"); // Hello, TEST will be the template value. "Hello, %s" defined in yml.
        if (!saying.contains("TEST")) {
            return Result.unhealthy("template doesn't include a name");
        }
        return Result.healthy();
    }
}
