package com.RatingService.Controller;

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


import com.RatingService.Model.Rating;
import com.RatingService.Repo.RatingRepo;
import com.RatingService.Service.RatingService;

@RestController
@RequestMapping("/rating")
public class RatingController {
	
	@Autowired
	private RatingService ratingService;
	
	@PostMapping("/save")
	private ResponseEntity<Rating> saveRating(@Valid @RequestBody Rating rating)
	{
		Rating ratingNew=ratingService.createRating(rating);
		
		
		return new ResponseEntity<Rating>(ratingNew,HttpStatus.OK);
	}
	
	@GetMapping("/getAll")
	private ResponseEntity<List<Rating>> getAllRating()
	{
		 List<Rating> list=ratingService.getRatings();
		
		
		return new ResponseEntity<List<Rating>>(list,HttpStatus.OK);
	}
	
	
	@GetMapping("/getByUser/{userId}")
	private ResponseEntity<List<Rating>> getRatingByUserId(@Valid @PathVariable Integer userId)
	{
		List<Rating> list=ratingService.getRatingByUserId(userId);
		
		return new ResponseEntity<List<Rating>>(list,HttpStatus.CREATED);
	}
	
	@GetMapping("/getByHotel/{hotelId}")
	private ResponseEntity<List<Rating>> getRatingByHotelId(@Valid @PathVariable Integer hotelId)
	{
		List<Rating> list=ratingService.getRatingByHotelId(hotelId);
		
		return new ResponseEntity<List<Rating>>(list,HttpStatus.CREATED);
	}

}
