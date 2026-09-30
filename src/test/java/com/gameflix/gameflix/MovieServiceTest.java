package com.gameflix.gameflix;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class MovieServiceTest {

    @Autowired
    private MovieService movieService;

    @Test
    void getAllMovies_ShouldReturnList() {
        var movies = movieService.getAllMovies();
        assertNotNull(movies);
    }

    @Test
    void movieService_ShouldBeNotNull() {
        assertNotNull(movieService, "MovieService bean should be loaded");
    }

    @Test
    void testServiceLogicValidation() {
        var movies = movieService.getAllMovies();
        assertNotNull(movies);
    }
}
