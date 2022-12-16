package com.UserService.Service;

import java.util.List;

import com.UserService.Model.User;





public interface UserService {
	
	public User saveUser(User user);
	
	public List<User> getAllUsers();
	
	public User getUser(Integer userId);
	
	

}
