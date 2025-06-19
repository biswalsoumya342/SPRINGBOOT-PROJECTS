package com.soumya.blogapp.services;

import java.util.List;

import com.soumya.blogapp.payloads.CategoryDto;


public interface CategoryService {
	//Add
	public boolean add(CategoryDto dto);
	
	//FindAll
	public List<CategoryDto> findAll();
	
	//FindOne
	public CategoryDto findOne(Integer id);
	
	//Update
	public boolean update(Integer id,CategoryDto dto);
	
	//Delete
	public boolean delete(Integer id);
	
}
