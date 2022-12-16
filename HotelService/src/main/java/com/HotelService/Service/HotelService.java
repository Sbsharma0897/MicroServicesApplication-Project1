package com.HotelService.Service;

import java.util.List;

import com.HotelService.Model.Hotel;



public interface HotelService {
	
    public Hotel saveHotel(Hotel hotel);
	
	public List<Hotel> getAllHotels();
	
	public Hotel getHotel(Integer hotelId);

}
