package com.amir.rating.Services;

import com.amir.rating.Entities.Rating;

import java.util.List;

public interface RatingService {

    Rating create(Rating rating);

    List<Rating> getRating();

    List<Rating> getRatingByUserId(Integer userId);

    List<Rating> getRatingByHotelId(Integer hotelId);
}
