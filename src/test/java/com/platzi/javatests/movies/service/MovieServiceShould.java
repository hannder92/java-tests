package com.platzi.javatests.movies.service;

import com.platzi.javatests.movies.data.MovieRepository;
import com.platzi.javatests.movies.model.Genre;
import com.platzi.javatests.movies.model.Movie;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;

import static com.platzi.javatests.movies.model.Genre.*;


class MovieServiceShould {

    private MovieService movieService;
    private MovieRepository movieRepository;


    @BeforeEach
    public void setup() {
        movieRepository = Mockito.mock(MovieRepository.class);
        Mockito.when(movieRepository.findAll()).thenReturn(
                Arrays.asList(
                        new Movie(1, "Dark Knight", 152, ACTION),
                        new Movie(2, "Memento", 113, THRILLER),
                        new Movie(3, "There's Something About Mary", 119, COMEDY),
                        new Movie(4, "Super 8", 112, THRILLER),
                        new Movie(5, "Scream", 111, HORROR),
                        new Movie(6, "Home Alone", 103, COMEDY),
                        new Movie(7, "Matrix", 136, ACTION)
                )
        );
        movieService = new MovieService(movieRepository);
    }

    @Test
    void returnMoviesByGenre() {
        Collection<Movie> movies = movieService.findMoviesByGenre(Genre.COMEDY);
        Assertions.assertEquals(Arrays.asList(3, 6), getMoviesIds(movies));
    }

    @Test
    void returnMoviesByDuration() {
        Collection<Movie> movies = movieService.findMoviesByDuration(120);
        Assertions.assertEquals(Arrays.asList(2, 3, 4, 5, 6), getMoviesIds(movies));
    }

    private Collection<Integer> getMoviesIds(Collection<Movie> movies) {
        return movies.stream().map(Movie::getId).collect(Collectors.toList());
    }


}