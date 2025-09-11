package com.north.democustomerresponse.service;

import com.north.democustomerresponse.model.UserProfile;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class SensitiveDataService {

    public boolean isSensitiveData(UserProfile userProfile) {
        log.info("Checking if user {} can see sensitive data", userProfile.getUsername());
        return userProfile.isCanSeeSensitiveData();
    }
}
