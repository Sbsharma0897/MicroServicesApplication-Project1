package com.RatingService.Service;

import java.util.List;

import com.RatingService.Model.Rating;

public interface RatingService {

	public Rating createRating(Rating rating);
	
	public List<Rating> getRatings();
	
	public List<Rating> getRatingByUserId(Integer userId);
	
	public List<Rating> getRatingByHotelId(Integer hotelId);
	
	
	
}
