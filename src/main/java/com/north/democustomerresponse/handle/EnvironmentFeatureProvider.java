package com.north.democustomerresponse.handle;

import org.springframework.core.env.Environment;

public class EnvironmentFeatureProvider implements FeatureProvider {
    private final Environment env;

    public EnvironmentFeatureProvider(Environment env) {
        this.env = env;
    }

    @Override
    public boolean isEnabled(String key) {
        // property name like feature.new.checkout=true
        return env.getProperty("feature." + key, Boolean.class, false);
    }
}
