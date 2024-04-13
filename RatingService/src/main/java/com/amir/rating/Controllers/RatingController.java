package com.amir.rating.Controllers;

import com.amir.rating.Entities.Rating;
import com.amir.rating.Services.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ratings")
public class RatingController {

    @Autowired
    private RatingService ratingService;

    @PostMapping
    public ResponseEntity<Rating> createRating(@RequestBody Rating rating) {
        Rating rating1 = ratingService.create(rating);
        return new ResponseEntity<>(rating1, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Rating>> getRatings() {
        return ResponseEntity.ok(ratingService.getRating());
    }

    @GetMapping("/users/{userId}")
    public ResponseEntity<List<Rating>> getRatingByUserId(@PathVariable Integer userId) {
        return ResponseEntity.ok(ratingService.getRatingByUserId(userId));
    }

    @GetMapping("/hotels/{hotelId}")
    public ResponseEntity<List<Rating>> getRatingByHotelId(@PathVariable Integer hotelId) {
        List<Rating> ratingByHotelId = ratingService.getRatingByHotelId(hotelId);
        return new ResponseEntity<>(ratingByHotelId, HttpStatus.OK);
    }
}
