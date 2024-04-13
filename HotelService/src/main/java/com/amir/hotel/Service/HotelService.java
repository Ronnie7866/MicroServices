// HotelService.java
package com.amir.hotel.Service;

import com.amir.hotel.Entities.Hotel;

import java.util.List;

public interface HotelService {

    Hotel createHotel(Hotel hotel);

    List<Hotel> getAllHotel();

    Hotel get(Integer id);

    Hotel updateHotel(Hotel hotel); // Add an update method

    Hotel deleteHotel(Integer id); // It's better to return void for delete operations
}
