package com.HotelService.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.HotelService.Exception.ResourceNotFoundException;
import com.HotelService.Model.Hotel;
import com.HotelService.Repo.HotelRepo;


@Service
public class HotelServiceImpl implements HotelService{
	
	@Autowired
	private HotelRepo hotelRepo;

	@Override
	public Hotel saveHotel(Hotel hotel) {
		
		Hotel returnedUser=null;
		try {
			returnedUser=hotelRepo.save(hotel);
		} catch (Exception e) {
			throw new ResourceNotFoundException("hotel with same email already exists");
		}
		return returnedUser; 
	}

	@Override
	public List<Hotel> getAllHotels() {
		
		List<Hotel> list=hotelRepo.findAll();
		return list;
	}

	@Override
	public Hotel getHotel(Integer hotelId) {
		
		Optional<Hotel> optional=hotelRepo.findById(hotelId);
		if(optional.isEmpty())
		{
			throw new ResourceNotFoundException("hotel not present");
		}
		
		return optional.get();
	
	}

}
