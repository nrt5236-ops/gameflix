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
        // Ensures the Spring application context and MovieService bean load successfully
        assertNotNull(movieService, "MovieService bean should be loaded");
    }

    @Test
    void getAllMovies_ShouldReturnMovieList() {
        // Test business logic for fetching movies
        var movies = movieService.getAllMovies();
        assertNotNull(movies, "The returned movie list should not be null");
    }
}
