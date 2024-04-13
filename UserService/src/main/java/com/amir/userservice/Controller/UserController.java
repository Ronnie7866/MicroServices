package com.amir.userservice.Controller;

import com.amir.userservice.Entity.User;
import com.amir.userservice.Services.UserService;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.retry.annotation.Retry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user) {
        User savedUser = userService.saveUser(user);
        return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
    }

    //@CircuitBreaker(name = "ratingHotelBreaker", fallbackMethod = "ratingHotelFallback")
    int retrycnt = 0;
    @GetMapping("/{userid}")
//    @Retry(name = "ratingHotelService", fallbackMethod = "ratingHotelFallback")
    @RateLimiter(name = "userRateLimiter", fallbackMethod = "ratingHotelFallback")
    public ResponseEntity<User> getSingleUser(@PathVariable Integer userid) {
        System.out.println("retry Count : " + retrycnt);
        retrycnt++;
        User user = userService.getUser(userid);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    // crating fallback method for circuit breaker
    // Corrected fallback method signature
    public ResponseEntity<User> ratingHotelFallback(Integer userId, Exception exception) {
        //System.out.println("Fallback is executed because service is down: " + exception.getMessage());
        User dummy = User.builder()
                .email("dummy@gmail.com")
                .name("Dummy")
                .about("This user is created because service is down")
                .userId(10)
                .build();
        return new ResponseEntity<>(dummy, HttpStatus.OK);
}

    @GetMapping
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> allUser = userService.getAllUser();
        return new ResponseEntity<>(allUser, HttpStatus.OK);
    }
    
    
}
