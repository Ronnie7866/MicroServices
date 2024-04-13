package com.amir.userservice;

import com.amir.userservice.Entity.Rating;
import com.amir.userservice.external.service.RatingService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class UserServiceApplicationTests {

    @Test
    void contextLoads() {
    }

    @Autowired
    private RatingService ratingService;

//    @Test
//    void createRating() {
//        Rating rating = Rating.builder().rating(10).userId(5).hotelId(5).feedback("this is created using Feign Client").build();
//        Rating savedRating = ratingService.createRating(rating);
//        System.out.println("new Rating created");
//    }

}
