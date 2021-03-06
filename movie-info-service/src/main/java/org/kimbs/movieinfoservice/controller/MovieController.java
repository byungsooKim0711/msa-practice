package org.kimbs.movieinfoservice.controller;

import java.util.UUID;

import org.kimbs.movieinfoservice.models.Movie;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/movies")
public class MovieController {

    @GetMapping("/{movieId}")
    public Movie getMovieInfo(@PathVariable(name = "movieId") String movieId) {
        return new Movie(movieId, UUID.randomUUID().toString().replace("-", ""));
    }
}