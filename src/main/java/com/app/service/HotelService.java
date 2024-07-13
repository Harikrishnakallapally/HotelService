package com.app.service;

import com.app.dto.HotelDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface HotelService {
    HotelDTO createHotel(HotelDTO hotelDTO);
    List<HotelDTO> getAllHotels();
    HotelDTO getHotelById(String hotelId);
}
