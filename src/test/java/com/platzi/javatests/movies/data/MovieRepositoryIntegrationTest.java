package com.platzi.javatests.movies.data;

import com.platzi.javatests.movies.model.Movie;
import org.junit.jupiter.api.*;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.datasource.init.ScriptUtils;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;
import java.util.Collection;

import static com.platzi.javatests.movies.model.Genre.*;
import static org.junit.jupiter.api.Assertions.*;

class MovieRepositoryIntegrationTest {

    private MovieRepositoryImpl movieRepository;
    private DriverManagerDataSource dataSource;

    @BeforeEach
    void setUp() throws SQLException {
        dataSource = new DriverManagerDataSource("jdbc:h2:mem:test;MODE=MYSQL", "sa", "sa");
        ScriptUtils.executeSqlScript(dataSource.getConnection(), new ClassPathResource("test-data.sql"));
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        movieRepository = new MovieRepositoryImpl(jdbcTemplate);
    }

    @Test
    void loadAllMovies() {
        Collection<Movie> movies = movieRepository.findAll();
        Assertions.assertEquals(Arrays.asList(
                new Movie(1, "Dark Knight", 152, ACTION),
                new Movie(2, "Memento", 113, THRILLER),
                new Movie(3, "Matrix", 136, ACTION)
        ), movies);
    }

    @Test
    void loadMovieById() {
        Movie movie = movieRepository.findById(2);
        Assertions.assertEquals(new Movie(2, "Memento", 113, THRILLER), movie);
    }

    @Test
    void insertAMovie() {
        Movie movie = new Movie("Super 8", 112, THRILLER);
        movieRepository.saveOrUpdate(movie);

        Movie movieFromDB = movieRepository.findById(4);
        assertEquals(new Movie(4, "Super 8", 112, THRILLER), movieFromDB);

    }

    @AfterEach
    void tearDown() throws SQLException {
        final Statement s = dataSource.getConnection().createStatement();
        s.execute("drop all objects delete files");
    }
}