package com.north.democustomerresponse.handle;

import com.north.democustomerresponse.annotation.FeatureToggle;
import com.north.democustomerresponse.exception.FeatureDisabledException;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

@Aspect
public class FeatureToggleAspect {

    private final FeatureProvider provider;

    public FeatureToggleAspect(FeatureProvider provider) {
        this.provider = provider;
    }

    @Around("@annotation(toggle)")
    public Object aroundMethod(ProceedingJoinPoint pjp, FeatureToggle toggle) throws Throwable {
        if (!provider.isEnabled(toggle.value())) {
            if (toggle.failClosed()) {
                throw new FeatureDisabledException("Feature disabled: " + toggle.value());
            }
            return null; // or Optional.empty(), or proceed with fallback
        }
        return pjp.proceed();
    }
}
