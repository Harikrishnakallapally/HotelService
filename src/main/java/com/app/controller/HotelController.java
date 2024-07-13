package com.app.controller;

import com.app.dto.ApiResponse;
import com.app.dto.HotelDTO;
import com.app.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/app/Hotel")
public class HotelController {
    @Autowired
    private HotelService hotelService;
    @PostMapping("/createHotel")

    public ResponseEntity<ApiResponse<HotelDTO>> createHotel(@RequestBody HotelDTO hotelDTO){
        ApiResponse<HotelDTO> response = new ApiResponse<>();
        HotelDTO DTO = hotelService.createHotel(hotelDTO);
        response.setStatusCode(200);
        response.setMessage("Hotel Created Successfully");
        response.setData(DTO);
        return ResponseEntity.ok().body(response);
    }
    @GetMapping("/getAllHotels")
    public ResponseEntity<ApiResponse<List<HotelDTO>>> getAllHotels(){
        ApiResponse<List<HotelDTO>> response = new ApiResponse<>();
        List<HotelDTO> getHotels = hotelService.getAllHotels();
        response.setStatusCode(200);
        response.setMessage("Hotels fetched Successfully");
        response.setData(getHotels);
        return ResponseEntity.ok().body(response);
    }
    @GetMapping("/getHotels/{hotelId}")
    public ResponseEntity<ApiResponse<HotelDTO>> getHotelById(@PathVariable String hotelId){
        ApiResponse<HotelDTO> response = new ApiResponse<>();
        HotelDTO getHotelById = hotelService.getHotelById(hotelId);
        response.setStatusCode(200);
        response.setMessage("Hotels getById Successfully");
        response.setData(getHotelById);
        return ResponseEntity.ok().body(response);
    }

}
