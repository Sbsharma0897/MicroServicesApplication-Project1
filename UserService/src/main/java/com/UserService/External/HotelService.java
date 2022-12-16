package com.UserService.External;

import javax.validation.Valid;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.UserService.Model.Hotel;


@FeignClient(name = "HOTELSERVICE",path ="hotel-api")
public interface HotelService {
	
	@GetMapping("/getHotel/{hotelId}")
	Hotel getHotel(@Valid @PathVariable Integer hotelId);
	
}
