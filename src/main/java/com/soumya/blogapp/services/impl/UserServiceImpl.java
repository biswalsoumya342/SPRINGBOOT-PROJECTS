package com.soumya.blogapp.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import com.soumya.blogapp.entities.User;
import com.soumya.blogapp.payloads.UserDto;
import com.soumya.blogapp.repositories.UserRepository;
import com.soumya.blogapp.services.UserService;
import com.soumya.blogapp.exceptions.ResourceNotFoundException;
import com.soumya.blogapp.mapper.UserMapper;
@Service
public class UserServiceImpl implements UserService {

	private UserRepository repo;
	private UserMapper mapper;
	
	public UserServiceImpl(UserRepository repo,UserMapper mapper) {
		this.repo = repo;
		this.mapper = mapper;
	}
	
	
	
	
	@Override
	public boolean addUser(UserDto userDto) {
		if(!ObjectUtils.isEmpty(userDto)) {
			User user = mapper.toUser(userDto);
			repo.save(user);
			return true;
		}else {
			return false;
		}
	}

	@Override
	public boolean updateUser(UserDto userDto, Integer userId) {
		User foundUser = repo.findById(userId).orElseThrow(()->new ResourceNotFoundException("User","Id",userId));
		foundUser.setName(userDto.getName());
		foundUser.setName(userDto.getEmail());
		foundUser.setPassword(userDto.getPassword());
		foundUser.setAbout(userDto.getAbout());
		
		repo.save(foundUser);
		return true;
	}

	@Override
	public UserDto getUserById(Integer userId) {
		User foundUser = repo.findById(userId).orElseThrow(()->new ResourceNotFoundException("User", "Id", userId));
		UserDto userDto = mapper.toDto(foundUser);
		return userDto;
	}

	@Override
	public List<UserDto> getAllUser() {
		List<User> users = repo.findAll();
		List<UserDto> userDto = new ArrayList<>();
		users.forEach(list->{
			UserDto dto = mapper.toDto(list);
			userDto.add(dto);
		});
		return userDto;
	}

	@Override
	public boolean deleteUser(Integer userId) {
		User foundUser = repo.findById(userId).orElseThrow(()->new ResourceNotFoundException("User", "Id", userId));
		repo.deleteById(userId);
		return true;
	}

}
