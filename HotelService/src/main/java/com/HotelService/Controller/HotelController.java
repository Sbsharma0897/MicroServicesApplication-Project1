package com.HotelService.Controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.HotelService.Model.Hotel;
import com.HotelService.Service.HotelService;

@RestController
@RequestMapping("/hotel-api")
public class HotelController {
	
	@Autowired
	private HotelService hotelService;
	
	@PostMapping("/save")
	private ResponseEntity<Hotel> saveHotel(@Valid @RequestBody Hotel hotel)
	{
		Hotel hotelnew=hotelService.saveHotel(hotel);
		
		
		return new ResponseEntity<Hotel>(hotelnew,HttpStatus.OK);
	}
	
	@GetMapping("/getAll")
	private ResponseEntity<List<Hotel>> getAllHotel()
	{
		 List<Hotel> list=hotelService.getAllHotels();
		
		
		return new ResponseEntity<List<Hotel>>(list,HttpStatus.OK);
	}
	
	
	@GetMapping("/getHotel/{hotelId}")
	private ResponseEntity<Hotel> getHotel(@Valid @PathVariable Integer hotelId)
	{
		Hotel user=hotelService.getHotel(hotelId);
		
		return new ResponseEntity<Hotel>(user,HttpStatus.CREATED);
	}

}
