package com.north.democustomerresponse.config;

import com.north.democustomerresponse.handle.EnvironmentFeatureProvider;
import com.north.democustomerresponse.handle.FeatureProvider;
import com.north.democustomerresponse.handle.FeatureToggleAspect;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FeatureConfig {
    @Bean
    public FeatureProvider featureProvider(org.springframework.core.env.Environment env) {
        return new EnvironmentFeatureProvider(env);
    }

    @Bean
    public FeatureToggleAspect featureToggleAspect(FeatureProvider provider) {
        return new FeatureToggleAspect(provider);
    }
}
