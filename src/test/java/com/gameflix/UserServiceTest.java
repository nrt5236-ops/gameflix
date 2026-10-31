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
    void testRegisterUser() {
        boolean isRegistered = userService.registerUser("testuser123", "securepassword123");
        Assertions.assertTrue(isRegistered, "User should register successfully");
    }

    @Test
    void testAuthenticateUser() {
        userService.registerUser("authuser123", "mysecurepassword");
        boolean isAuthenticated = userService.authenticateUser("authuser123", "mysecurepassword");
        Assertions.assertTrue(isAuthenticated, "User should authenticate with correct credentials");
    }

    @Test
    void testRegisterDuplicateUserShouldFail() {
        userService.registerUser("dupuser123", "password123");
        boolean isRegisteredAgain = userService.registerUser("dupuser123", "differentpassword");
        Assertions.assertFalse(isRegisteredAgain, "Registering a duplicate username should fail");
    }

    @Test
    void testAuthenticateUserInvalidPasswordShouldFail() {
        userService.registerUser("failuser123", "correctpassword");
        boolean isAuthenticated = userService.authenticateUser("failuser123", "wrongpassword");
        Assertions.assertFalse(isAuthenticated, "Authentication should fail with an incorrect password");
    }
}
