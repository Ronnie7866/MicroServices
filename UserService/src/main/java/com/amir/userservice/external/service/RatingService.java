package com.amir.userservice.external.service;

import com.amir.userservice.Entity.Rating;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import java.util.Map;

@Service
@FeignClient(name = "RATING-SERVICE")
public interface RatingService {

    // we just have to create methods we can get method body at runtime by Feign Client this is also called as Declarative Approach

    //get

    //post
    @PostMapping("/ratings")
    Rating createRating(Rating rating);

    //put
    @PutMapping("/ratings/{ratingId}")
    Rating updateRating(@PathVariable String ratingId, Rating rating);

    @DeleteMapping("/ratings/{ratingId}")
    public void deleteRating(@PathVariable String ratingId);
}
