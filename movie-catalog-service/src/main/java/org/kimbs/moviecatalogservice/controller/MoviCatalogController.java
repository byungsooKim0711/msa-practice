package org.kimbs.moviecatalogservice.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.kimbs.moviecatalogservice.models.CatalogItem;
import org.kimbs.moviecatalogservice.models.Movie;
import org.kimbs.moviecatalogservice.models.Rating;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/catalog")
public class MoviCatalogController {

    private final RestTemplate restTemplate;

    public MoviCatalogController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @RequestMapping("/{userId}")
    public List<CatalogItem> getCatalog(@PathVariable(name = "userId") String userId) {

        List<Rating> ratings = restTemplate.exchange(
            "http://localhost:8082/rating/users/" + userId, 
            HttpMethod.GET, 
            null,
            new ParameterizedTypeReference<List<Rating>>() {}).getBody();

        return ratings
            .stream()
            .map(rating -> {
                Movie movie = restTemplate.getForObject("http://localhost:8081/movies/" + rating.getMovieId(), Movie.class);
                return new CatalogItem(movie.getName(), "Describsion", 4);
            })
            .collect(Collectors.toList());
    }
}