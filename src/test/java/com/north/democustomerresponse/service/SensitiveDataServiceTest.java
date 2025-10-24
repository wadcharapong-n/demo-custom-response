package com.north.democustomerresponse.service;

import com.north.democustomerresponse.model.UserProfile;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.stereotype.Service;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class SensitiveDataServiceTest {

    @InjectMocks
    private SensitiveDataService sensitiveDataService;

    @Test
    void isSensitiveData() {
        UserProfile allowedUser = new UserProfile();
        allowedUser.setUsername("allowed_user");
        allowedUser.setCanSeeSensitiveData(true);

        UserProfile deniedUser = new UserProfile();
        deniedUser.setUsername("denied_user");
        deniedUser.setCanSeeSensitiveData(false);

        assertTrue(sensitiveDataService.isSensitiveData(allowedUser));
        assertFalse(sensitiveDataService.isSensitiveData(deniedUser));
    }
}