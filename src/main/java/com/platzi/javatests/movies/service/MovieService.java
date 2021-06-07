package com.platzi.javatests.movies.service;

import com.platzi.javatests.movies.data.MovieRepository;
import com.platzi.javatests.movies.model.Genre;
import com.platzi.javatests.movies.model.Movie;

import java.util.Collection;
import java.util.stream.Collectors;

public class MovieService {

    private final MovieRepository movieRepository;

    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public Collection<Movie> findMoviesByGenre(Genre genre) {
        Collection<Movie> allMovies = movieRepository.findAll();
        return allMovies.stream()
                .filter(m -> genre.equals(m.getGenre()))
                .collect(Collectors.toList());
    }

    public Collection<Movie> findMoviesByDuration(int duration) {
        Collection<Movie> allMovies = movieRepository.findAll();
        return allMovies.stream()
                .filter(m -> m.getMinutes() <= duration)
                .collect(Collectors.toList());
    }
}
