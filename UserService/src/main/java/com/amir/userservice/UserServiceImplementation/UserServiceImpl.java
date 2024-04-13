package com.amir.userservice.UserServiceImplementation;

import com.amir.userservice.Entity.Hotel;
import com.amir.userservice.Entity.Rating;
import com.amir.userservice.Entity.User;
import com.amir.userservice.Exception.ResourceNotFoundException;
import com.amir.userservice.Repositories.UserRepo;
import com.amir.userservice.Services.UserService;
import com.amir.userservice.external.service.HotelService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepo userRepo;

    @Autowired
    private RestTemplate restTemplate;

    private final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    private HotelService hotelService;

    @Autowired
    public UserServiceImpl(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    @Override
    public User saveUser(User user) {
        return userRepo.save(user);
    }

    @Override
    public List<User> getAllUser() {
        List<User> all = userRepo.findAll();
        List<User> listWithRating = new ArrayList<>();
        for (int i = 0; i < all.size(); i++) {
            User user = all.get(i);
            List forObject = restTemplate.getForObject("http://localhost:8083/ratings/users/" + user.getUserId(), List.class);
            user.setRatings(forObject);
            listWithRating.add(user);
        }
        return listWithRating;
    }

    @Override
    public User getUser(Integer userId) {
        User user = userRepo.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User not found " + userId));
        Rating[] ratingOfUser = restTemplate.getForObject("http://localhost:8083/ratings/users/" + user.getUserId(), Rating[].class);
        List<Rating> ratings = Arrays.stream(ratingOfUser).toList();
        List<Rating> ratingList = ratings.stream().map(rating -> {
//            ResponseEntity<Hotel> forEntity = restTemplate.getForEntity("http://localhost:8082/hotels/" + rating.getHotelId(), Hotel.class);

            Hotel hotel = hotelService.getHotel(rating.getHotelId());
            rating.setHotel(hotel);
            return rating;
        }).collect(Collectors.toList());

        // api call to hotel service to get hotel
                // http://localhost:8082/hotels/2
                // set the hotel to rating
                // return the rating
        user.setRatings(ratingList);

        return user;
    }

    @Override
    public User deleteUser(Integer userId) {
        return null;
    }

    @Override
    public User updateUser(User user) {
        return null;
    }
}
