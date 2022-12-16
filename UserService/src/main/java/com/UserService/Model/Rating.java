package com.UserService.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;



@Getter
@Setter
@NoArgsConstructor
public class Rating {
	
	
	private Integer ratingId;
	private Integer userId;
	private Integer hotelId;
	private Integer rating;
	private String feedback;
	
	private Hotel hotel=new Hotel();

}
