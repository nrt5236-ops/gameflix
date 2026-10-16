package com.gameflix;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class UserServiceTest {

    @Autowired
    private UserService userService;

    @Test
    void testServiceLoadedSuccessfully() {
        Assertions.assertNotNull(userService, "UserService should not be null");
    }

    @Test
    void testRegisterNewUser() {
        // Test registering a unique user
        boolean isRegistered = userService.registerUser("testuser123", "securepassword123");
        Assertions.assertTrue(isRegistered, "User should register successfully");
    }

    @Test
    void testAuthenticateUser() {
        // Register first, then test authentication
        userService.registerUser("authuser123", "mypassword");
        boolean isAuthenticated = userService.authenticateUser("authuser123", "mypassword");
        Assertions.assertTrue(isAuthenticated, "User should authenticate with correct credentials");
    }
}
