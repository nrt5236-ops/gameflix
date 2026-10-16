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

    @Test
    void testRegisterDuplicateUser_ShouldFail() {
        // Test that registering the exact same username twice returns false
        userService.registerUser("dupuser123", "password123");
        boolean isRegisteredAgain = userService.registerUser("dupuser123", "differentpassword");
        Assertions.assertFalse(isRegisteredAgain, "Registering a duplicate username should fail");
    }

    @Test
    void testAuthenticateUser_InvalidPassword_ShouldFail() {
        // Test that authenticating with an incorrect password returns false
        userService.registerUser("failuser123", "correctpassword");
        boolean isAuthenticated = userService.authenticateUser("failuser123", "wrongpassword");
        Assertions.assertFalse(isAuthenticated, "Authentication should fail with an incorrect password");
    }
}
