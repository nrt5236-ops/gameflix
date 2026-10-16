package com.gameflix;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class MovieServiceTest {

    @Autowired
    private MovieService movieService;

    @Test
    void getAllMovies_ShouldReturnList() {
        var movies = movieService.getAllMovies();
        Assertions.assertFalse(movies.isEmpty());
    }

    @Test
    void testServiceLoadedSuccessfully() {
        Assertions.assertNotNull(movieService, "MovieService should not be null");
    }

    @Test
    void testAdditionalServiceLogic() {
        Assertions.assertDoesNotThrow(() -> movieService.getAllMovies());
    }
}
