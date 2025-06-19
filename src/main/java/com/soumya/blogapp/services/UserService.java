package com.soumya.blogapp.services;

import java.util.List;

import com.soumya.blogapp.payloads.UserDto;

public interface UserService {
	public boolean addUser(UserDto userDto);
	
	public boolean updateUser(UserDto userDto,Integer userId);
	
	public UserDto getUserById(Integer userId);
	
	public List<UserDto> getAllUser();
	
	public boolean deleteUser(Integer userId);
}
