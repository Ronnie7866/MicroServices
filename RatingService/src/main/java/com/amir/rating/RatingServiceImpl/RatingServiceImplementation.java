package com.amir.rating.RatingServiceImpl;

import com.amir.rating.Entities.Rating;
import com.amir.rating.Repositories.RatingRepositories;
import com.amir.rating.Services.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RatingServiceImplementation implements RatingService {

    @Autowired
    private RatingRepositories ratingRepositories;


    @Override
    public Rating create(Rating rating) {
        return ratingRepositories.save(rating);
    }

    @Override
    public List<Rating> getRating() {
        return ratingRepositories.findAll();
    }

    @Override
    public List<Rating> getRatingByUserId(Integer userId) {
        return ratingRepositories.findByUserId(userId);
    }

    @Override
    public List<Rating> getRatingByHotelId(Integer hotelId) {
        return ratingRepositories.findByHotelId(hotelId);
    }
}
