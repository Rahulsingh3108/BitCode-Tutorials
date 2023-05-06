package com.app.services;

import java.util.List;

import com.app.dtos.LoggedInUserDto;
import com.app.dtos.UserRegisterDto;
import com.app.dtos.UserRegisterSuccessDto;
import com.app.pojos.HealthServiceEntity;
import com.app.pojos.User;

public interface UserService {
	List<User> getAllUsers();
	
	UserRegisterSuccessDto registerUser(UserRegisterDto user);
	
	LoggedInUserDto getUserByUsername(String username);
	
	//User updateUserPassword(User updateUserPassword);
	
	User updateUserProfile(User updateUserProfile);
	
	List<HealthServiceEntity> fetchUsersServices(Long userId);
}
