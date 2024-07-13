package com.app.mapper;

import com.app.dto.HotelDTO;
import com.app.entity.Hotel;
import org.modelmapper.ModelMapper;

public class HotelMapper {
   public  static  final ModelMapper modelmapper = new ModelMapper();

   public static HotelDTO convertToDTO(Hotel hotel){
       return modelmapper.map(hotel,HotelDTO.class);
   }
   public static  Hotel convertToEntity(HotelDTO hotelDTO){
       return  modelmapper.map(hotelDTO,Hotel.class);
   }
}
