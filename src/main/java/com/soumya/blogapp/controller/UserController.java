package com.soumya.blogapp.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.soumya.blogapp.payloads.ApiResponse;
import com.soumya.blogapp.payloads.UserDto;
import com.soumya.blogapp.services.UserService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/user")
public class UserController {
	
	private UserService service;
	
	public UserController(UserService service) {
		this.service = service;
	}
	
	
	@PostMapping("/add")
	public ResponseEntity<?> addUser(@Valid @RequestBody UserDto userDto){
		boolean status = service.addUser(userDto);
		if(status) return ResponseEntity.ok(new ApiResponse(LocalDateTime.now(),"User Added Successful",true,HttpStatus.OK.value()));
		else return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("User Can Not Null");
	}
	
	@GetMapping("/find-by-id/{userId}")
	public ResponseEntity<?> getUserById(@PathVariable Integer userId){
		
			UserDto userDto = service.getUserById(userId);
			return new ResponseEntity<>(userDto,HttpStatus.OK);
		
	}
	
	
	@GetMapping("/find-all")
	public ResponseEntity<?> getAllUser(){
		List<UserDto> userDto = service.getAllUser();
		return new ResponseEntity<>(userDto,HttpStatus.OK);
	}
	
	
	@PutMapping("/update-user/{userId}")
	public ResponseEntity<?> updateUser(@Valid @RequestBody UserDto userDto, @PathVariable Integer userId){
		
			service.updateUser(userDto, userId);
			return new ResponseEntity<>(new ApiResponse(LocalDateTime.now(),"User Update Successful",true,HttpStatus.OK.value()),HttpStatus.OK);
		
	}
	
	@DeleteMapping("/delete-user/{userId}")
	public ResponseEntity<?> deleteUser(@PathVariable Integer userId){
		
			service.deleteUser(userId);
			return new ResponseEntity<>(new ApiResponse(LocalDateTime.now(),"User Delete Successful",true,HttpStatus.OK.value()),HttpStatus.OK);
		
	}
	
}
