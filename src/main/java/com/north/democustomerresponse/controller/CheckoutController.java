package com.north.democustomerresponse.controller;

import com.north.democustomerresponse.annotation.FeatureToggle;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class CheckoutController {

    @GetMapping("/checkout")
    @FeatureToggle(value = "new.checkout", failClosed = true)
    public ResponseEntity<String> checkoutNewFeatures() {
        return ResponseEntity.ok("checkout");
    }
}
