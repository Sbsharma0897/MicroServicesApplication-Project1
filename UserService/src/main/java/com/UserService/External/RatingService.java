package com.UserService.External;

import java.util.List;

import javax.validation.Valid;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.UserService.Model.Rating;



@FeignClient(name = "RATINGSERVICE",path = "/rating")
public interface RatingService {
	
	@GetMapping("/getByUser/{userId}")
	ResponseEntity<List<Rating>> getRatingByUserId(@PathVariable Integer userId);
	

}
