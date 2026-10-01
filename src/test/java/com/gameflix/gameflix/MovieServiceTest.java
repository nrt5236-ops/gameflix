package com.gameflix;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class MovieServiceTest {

    @Autowired
    private MovieService movieService;

    @Test
    void contextLoads() {
        // Verifies that the Spring application context and MovieService bean load correctly
        assertNotNull(movieService, "MovieService bean should be loaded");
    }

    @Test
    void getAllMovies_ShouldReturnList() {
        // Ensures the service layer logic runs cleanly in the test environment
        var movies = movieService.getAllMovies();
        assertNotNull(movies, "The movie list should not be null");
    }
}
