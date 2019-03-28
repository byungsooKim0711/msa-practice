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
class RatingController {

    @GetMapping("/{movieId}")
    fun getRating(@PathVariable("movieId") movieId: String): Rating =
        Rating(movieId, 4)

    @GetMapping("/users/{userId}")
    fun getUserRating(@PathVariable("userId") userId: String): ArrayList<Rating> {
        val arrayList = ArrayList<Rating>();
        arrayList.add(Rating("Test001", 4));
        arrayList.add(Rating("Test002", 3));
        arrayList.add(Rating("Test003", 10));
        return arrayList;
    }
        
}