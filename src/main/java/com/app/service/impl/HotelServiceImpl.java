package com.app.service.impl;

import com.app.dto.HotelDTO;
import com.app.entity.Hotel;
import com.app.mapper.HotelMapper;
import com.app.repository.HotelRepository;
import com.app.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
@Service
public class HotelServiceImpl implements HotelService {
    @Autowired
    private HotelRepository hotelRepository;
    @Override
    public HotelDTO createHotel(HotelDTO hotelDTO) {
        Hotel hotel = HotelMapper.convertToEntity(hotelDTO);
        Hotel saveHotel= hotelRepository.save(hotel);

        HotelDTO hotelDTO1 = HotelMapper.convertToDTO(saveHotel);

        return hotelDTO1;
    }

    @Override
    public List<HotelDTO> getAllHotels() {
        List<Hotel> hotel = hotelRepository.findAll();

        List<HotelDTO> hotelDTOS = hotel.stream().map(h->HotelMapper.convertToDTO(h)).collect(Collectors.toList());
        return hotelDTOS;
    }

    @Override
    public HotelDTO getHotelById(String hotelId) {
        Hotel hotel = hotelRepository.findById(hotelId).orElseThrow(()-> new RuntimeException("HotelId NotFounded"));
        HotelDTO hotelDTO= HotelMapper.convertToDTO(hotel);
        return hotelDTO;
    }
}
