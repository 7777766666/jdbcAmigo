package com.amigoscode.movie;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class MovieDataAccessService implements MovieDao {

    private final JdbcTemplate jdbcTemplate;

    public MovieDataAccessService(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Movie> selectMovies() {
        var sql = """
                SELECT id, name, release_date
                FROM postgres.public.movie
                LIMIT 100;
                 """;
        return jdbcTemplate.query(sql, new MovieRowMapper());
    }

    @Override
    public int insertMovie(Movie movie) {
        var sql = """
                INSERT INTO postgres.public.movie(name, release_date)
                VALUES (?, ?);
                 """;
        return jdbcTemplate.update(
                sql,
                movie.name(), movie.releaseDate()
        );
    }

    @Override
    public int deleteMovie(int id) {
        var sql = """
                DELETE FROM postgres.public.movie   
                WHERE id = ?
                """;
        return jdbcTemplate.update(sql, id);
    }

    @Override
    public Optional<Movie> selectMovieById(int id) {
        var sql = """
                SELECT id, name, release_date
                FROM postgres.public.movie
                WHERE id = ?
                 """;
        return jdbcTemplate.query(sql, new MovieRowMapper(), id)
                .stream()
                .findFirst();
    }
    @Override
    public int patchMovie(Movie movie ){
        var sql = """
                UPDATE postgres.public.movie
                SET name = ?, release_date = ?
                WHERE id = ?
                
                """;
        return jdbcTemplate.update(sql,
                movie.name(), movie.releaseDate(), movie.id());
    }

}
