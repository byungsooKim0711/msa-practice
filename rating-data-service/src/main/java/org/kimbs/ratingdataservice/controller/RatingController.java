package org.kimbs.ratingdataservice.controller;

import java.util.Arrays;
import java.util.List;

import org.kimbs.ratingdataservice.models.Rating;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rating")
public class RatingController {


    @GetMapping("/{movieId}")
    public Rating getRating(@PathVariable("movieId") String movieId) {
        return new Rating(movieId, 4);
    }

    @GetMapping("/users/{userId}")
    public List<Rating> getUserRating(@PathVariable("userId") String userId) {
        return Arrays.asList(
            new Rating("Test001", 4),
            new Rating("Test002", 3),
            new Rating("Test003", 10)
        );
    }
}