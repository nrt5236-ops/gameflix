package com.gameflix;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
public class AuthController {

    private final UserService userService;

    public AuthController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody Map<String, String> request) {
        String username = request.get("username");
        String password = request.get("password");

        if (username == null || password == null || username.trim().isEmpty() || password.trim().isEmpty()) {
            return ResponseEntity.badRequest().body(Map.of("message", "Username and password cannot be empty"));
        }

        boolean success = userService.registerUser(username, password);
        if (!success) {
            return ResponseEntity.status(400).body(Map.of("message", "Username already exists"));
        }

        return ResponseEntity.ok(Map.of("message", "User registered successfully"));
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Map<String, String> request) {
        String username = request.get("username");
        String password = request.get("password");

        boolean isAuthenticated = userService.authenticateUser(username, password);
        if (!isAuthenticated) {
            return ResponseEntity.status(401).body(Map.of("message", "Invalid username or password"));
        }

        return ResponseEntity.ok(Map.of("message", "Login successful"));
    }
}