package com.north.democustomerresponse.handle;

import com.north.democustomerresponse.annotation.FeatureToggle;
import com.north.democustomerresponse.exception.FeatureDisabledException;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;

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
//            return ResponseEntity.status(HttpStatus.I_AM_A_TEAPOT).body("do something"); // or Optional.empty(), or proceed with fallback
            return null;
        }
        return pjp.proceed();
    }
}
