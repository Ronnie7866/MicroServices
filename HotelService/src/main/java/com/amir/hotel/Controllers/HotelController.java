// HotelController.java
package com.amir.hotel.Controllers;

import com.amir.hotel.Entities.Hotel;
import com.amir.hotel.Service.HotelService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hotels")
public class HotelController {

    private final HotelService hotelService;

    public HotelController(HotelService hotelService) {
        this.hotelService = hotelService;
    }

    @PostMapping()
    public ResponseEntity<Hotel> createHotel(@RequestBody Hotel hotel) {
        Hotel createdHotel = hotelService.createHotel(hotel);
        return new ResponseEntity<>(createdHotel, HttpStatus.CREATED);
    }

    @GetMapping("/{hotelId}")
    public ResponseEntity<Hotel> getHotel(@PathVariable Integer hotelId) {
        Hotel hotel = hotelService.get(hotelId);
        return new ResponseEntity<>(hotel, HttpStatus.OK);
    }

    @GetMapping()
    public ResponseEntity<List<Hotel>> getAllHotels() {
        List<Hotel> allHotels = hotelService.getAllHotel();
        return new ResponseEntity<>(allHotels, HttpStatus.OK);
    }

    // You should implement other CRUD operations like update and delete here.
}
