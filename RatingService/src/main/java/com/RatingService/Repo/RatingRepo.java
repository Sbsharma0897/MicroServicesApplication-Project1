package com.RatingService.Repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.RatingService.Model.Rating;

public interface RatingRepo extends JpaRepository<Rating, Integer>{

	List<Rating> findByUserId(Integer userId);
	
	List<Rating> findByHotelId(Integer hotelId);
}
