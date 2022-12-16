package com.UserService.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.UserService.Service.UserService;
import com.UserService.Model.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.persistence.*;


@RestController
@RequestMapping("/user-api")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@PostMapping("/save")
	private ResponseEntity<User> saveUser(@Valid @RequestBody User user)
	{
		User usernew=userService.saveUser(user);
		
		
		return new ResponseEntity<User>(usernew,HttpStatus.OK);
	}
	
	@GetMapping("/getAll")
	private ResponseEntity<List<User>> getAllUser()
	{
		 List<User> list=userService.getAllUsers();
		
		
		return new ResponseEntity<List<User>>(list,HttpStatus.OK);
	}
	
	
	@GetMapping("/getUser/{userId}")
	private ResponseEntity<User> getUser(@Valid @PathVariable Integer userId)
	{
		User user=userService.getUser(userId);
		
		return new ResponseEntity<User>(user,HttpStatus.CREATED);
	}
	
	

}
