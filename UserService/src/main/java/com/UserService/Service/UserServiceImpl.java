package com.UserService.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.hibernate.annotations.common.util.impl.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.UserService.Exception.ResourceNotFoundException;
import com.UserService.External.HotelService;
import com.UserService.External.RatingService;
import com.UserService.Model.Hotel;
import com.UserService.Model.Rating;
import com.UserService.Model.User;
import com.UserService.Repo.UserRepo;

import ch.qos.logback.classic.Logger;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserRepo userRepo;
	
//	@Autowired
//	private RestTemplate restTemplate;
	
	@Autowired
	private HotelService hotelService;
	
	@Autowired
	private RatingService ratingService;
	
	private Logger logger=(Logger) org.slf4j.LoggerFactory.getLogger(UserServiceImpl.class);

	@Override
	public User saveUser(User user) {
		
		User returnedUser=null;
		try {
			returnedUser=userRepo.save(user);
		} catch (Exception e) {
			throw new ResourceNotFoundException("user with same email already exists");
		}
		return returnedUser; 
		
	}

	@Override
	public List<User> getAllUsers() {
		
		List<User> list=userRepo.findAll();
		return list;
	}

	@Override
	public User getUser(Integer userId) {
		
		Optional<User> optional=userRepo.findById(userId);
		if(optional.isEmpty())
		{
			throw new ResourceNotFoundException("user not present");
		}
		
//		Rating[] ratingArray=restTemplate.getForObject("http://RATINGSERVICE/rating/getByUser/"+userId, Rating[].class);
//		//logger.info("{}", ratingList);
//	
//		List<Rating> list=Arrays.stream(ratingArray).toList();
//		
//	    User user=optional.get();
//	    user.setRatings(list);	    
//	    
//	    list.stream().forEach(rating->{
//	    	
//	    	
//	    	Hotel hotel=restTemplate.getForObject("http://HOTELSERVICE/hotel-api/getHotel/"+rating.getHotelId(), Hotel.class);
//	    	
//	    	rating.setHotel(hotel);
//	    	
//	    });
		System.out.println("begin");
		List<Rating> ratingList =ratingService.getRatingByUserId(userId).getBody();
		System.out.println("sdsd");
	    User user=optional.get();
	    user.setRatings(ratingList);	    
	    
	    ratingList.stream().forEach(rating->{
	    	
	    	
	    	Hotel hotel=hotelService.getHotel(rating.getHotelId());
	    	
	    	rating.setHotel(hotel);
	    	
	    });
	  
		return user;
	}

}
