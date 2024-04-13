package com.amir.hotel.Implementation;

import com.amir.hotel.Entities.Hotel;
import com.amir.hotel.Exception.ResourceNotFoundException;
import com.amir.hotel.Repository.HotelRepository;
import com.amir.hotel.Service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HotelServiceImplementation implements HotelService {

    @Autowired
    private HotelRepository hotelRepository;


    @Override
    public Hotel createHotel(Hotel hotel) {
        return hotelRepository.save(hotel);
    }

    @Override
    public List<Hotel> getAllHotel() {
        return hotelRepository.findAll();
    }

    @Override
    public Hotel get(Integer id) {
        return hotelRepository.findById(id).orElseThrow((() -> new ResourceNotFoundException("Hotel with given id is not found "+ id)));
    }

    @Override
    public Hotel updateHotel(Hotel hotel) {
        return null;
    }

    @Override
    public Hotel deleteHotel(Integer id) {
        return null;
    }
}
