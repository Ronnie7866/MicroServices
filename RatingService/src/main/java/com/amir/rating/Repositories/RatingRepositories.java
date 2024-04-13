package com.amir.rating.Repositories;

import com.amir.rating.Entities.Rating;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RatingRepositories extends MongoRepository<Rating, Integer> {

    // custom finder method
    List<Rating> findByUserId(Integer userId);

    List<Rating> findByHotelId(Integer hotelId);
}
