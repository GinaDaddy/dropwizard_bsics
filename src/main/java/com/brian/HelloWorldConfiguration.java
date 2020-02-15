package com.brian;

import org.hibernate.validator.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.dropwizard.Configuration;

/**
 * https://www.dropwizard.io/en/stable/getting-started.html
 *
 * STEP 1. Set configuration. The fields defined here should match to yml file. The yml will fill out this instance.
 *
 * When this class is deserialized from the YAML file, it will pull two root-level fields from the YAML object:
 * template, the template for our Hello World saying, and defaultName, the default name to use.
 * Both template and defaultName are annotated with @NotEmpty,
 * so if the YAML configuration file has blank values for either or is missing template entirely an informative exception will be thrown,
 * and your application won’t start.
 *
 * Both the getters and setters for template and defaultName are annotated with @JsonProperty,
 * which allows Jackson to both deserialize the properties from a YAML file but also to serialize it.
 *
 * Note
 * The mapping from YAML to your application’s Configuration instance is done by Jackson.
 * This means your Configuration class can use all of Jackson’s object-mapping annotations.
 * The validation of @NotEmpty is handled by Hibernate Validator, which has a wide range of built-in constraints for you to use.
 */
public class HelloWorldConfiguration extends Configuration {
    @NotEmpty
    private String template;

    @NotEmpty
    private String defaultName = "Stranger";

    @JsonProperty
    public String getTemplate() {
        return template;
    }

    @JsonProperty
    public void setTemplate(String template) {
        this.template = template;
    }

    @JsonProperty
    public String getDefaultName() {
        return defaultName;
    }

    @JsonProperty
    public void setDefaultName(String defaultName) {
        this.defaultName = defaultName;
    }
}
