package com.gameflix;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class MovieServiceTest {

    @Autowired(required = false)
    private MovieService movieService;

    @Test
    void getAllMovies_ShouldReturnList() {
        assertNotNull(movieService, "MovieService bean should be loaded");
        var movies = movieService.getAllMovies();
        assertNotNull(movies);
    }

    @Test
    void movieService_ShouldBeNotNull() {
        assertNotNull(movieService, "MovieService bean should be loaded");
    }

    @Test
    void testServiceLogicValidation() {
        assertNotNull(movieService, "MovieService bean should be loaded");
        var movies = movieService.getAllMovies();
        assertNotNull(movies);
    }
}
