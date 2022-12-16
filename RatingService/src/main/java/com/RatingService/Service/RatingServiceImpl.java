package com.RatingService.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.RatingService.Model.Rating;
import com.RatingService.Repo.RatingRepo;

@Service
public class RatingServiceImpl implements RatingService{
	
	@Autowired
	private RatingRepo ratingRepo;

	@Override
	public Rating createRating(Rating rating) 
	{
		return ratingRepo.save(rating);
		
	}

	@Override
	public List<Rating> getRatings() {
		
		return ratingRepo.findAll();
	}

	@Override
	public List<Rating> getRatingByUserId(Integer userId) {
		
		return ratingRepo.findByUserId(userId);
	}

	@Override
	public List<Rating> getRatingByHotelId(Integer hotelId) {
		
		return ratingRepo.findByHotelId(hotelId);
	}

}
