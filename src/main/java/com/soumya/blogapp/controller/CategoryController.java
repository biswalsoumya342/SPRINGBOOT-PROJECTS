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
import com.soumya.blogapp.payloads.CategoryDto;
import com.soumya.blogapp.services.CategoryService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/category")
public class CategoryController {

	private final CategoryService service;
	
	public CategoryController(CategoryService service) {
		this.service = service;
	}
	
	//Add
	@PostMapping("/add")
	public ResponseEntity<?> add(@Valid @RequestBody CategoryDto dto){
		service.add(dto);
		return new ResponseEntity<>(new ApiResponse(LocalDateTime.now(),"Category Added Successful",true,HttpStatus.OK.value()),HttpStatus.OK);
	}
	
	//Find-One
	@GetMapping("/find-one/{id}")
	public ResponseEntity<?> findOne(@PathVariable Integer id){
		CategoryDto dto = service.findOne(id);
		return new ResponseEntity<>(dto,HttpStatus.OK);
	}
	
	//Find-All
	@GetMapping("/find-all")
	public ResponseEntity<?> findAll(){
		List<CategoryDto> dto = service.findAll();
		return new ResponseEntity<>(dto,HttpStatus.OK);
	}
	
	//Update
	@PutMapping("/update/{id}")
	public ResponseEntity<?> update(@PathVariable Integer id,@Valid @RequestBody CategoryDto dto){
		service.update(id, dto);
		return new ResponseEntity<>(new ApiResponse(LocalDateTime.now(),"Category Update Successful",true,HttpStatus.OK.value()),HttpStatus.OK);
	}
	
	//Delete
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> delete(@PathVariable Integer id){
		service.delete(id);
		return new ResponseEntity<>(new ApiResponse(LocalDateTime.now(),"Category Delete Successful",true,HttpStatus.OK.value()),HttpStatus.OK);
	}
}
