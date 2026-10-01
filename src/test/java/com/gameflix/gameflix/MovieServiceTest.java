package com.gameflix.gameflix;

import com.gameflix.MovieService; // Import MovieService from its actual package
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
        assertNotNull(movieService, "MovieService bean should be loaded");
    }

    @Test
    void getAllMovies_ShouldReturnList() {
        var movies = movieService.getAllMovies();
        assertNotNull(movies, "The movie list should not be null");
    }
}
