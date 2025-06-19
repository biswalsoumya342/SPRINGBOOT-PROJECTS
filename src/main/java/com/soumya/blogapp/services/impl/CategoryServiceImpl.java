package com.soumya.blogapp.services.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.soumya.blogapp.entities.Category;
import com.soumya.blogapp.exceptions.JpaException;
import com.soumya.blogapp.exceptions.ResourceNotFoundException;
import com.soumya.blogapp.mapper.CategoryMapper;
import com.soumya.blogapp.payloads.CategoryDto;
import com.soumya.blogapp.repositories.CategoryRepository;
import com.soumya.blogapp.services.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService {

	private CategoryRepository repo;
	private CategoryMapper mapper;
	
	public CategoryServiceImpl(CategoryRepository repo,CategoryMapper mapper) {
		this.repo = repo;
		this.mapper = mapper;
	}
	
	//Add
	@Override
	public boolean add(CategoryDto dto) {
		Category category = mapper.toCategory(dto);
		Category save = repo.save(category);
		if(save != null && save.getCategoryId() != null) {
			return true;
		}else {
			throw new JpaException("Category", "Added");
		}
		
	}

	//Find - All
	@Override
	public List<CategoryDto> findAll() {
		List<Category> category = repo.findAll();
		List<CategoryDto> dto = category
				.stream()
				.map(list->mapper.toCategoryDto(list))
				.collect(Collectors.toList());
		return dto;
	}

	//Find-One
	@Override
	public CategoryDto findOne(Integer id) {
		Category found = repo.findById(id).orElseThrow(()-> new ResourceNotFoundException("Category", "Id", id));
		CategoryDto dto = mapper.toCategoryDto(found);
		return dto;
	}

	//Update - Category
	@Override
	public boolean update(Integer id, CategoryDto dto) {
		Category find = repo.findById(id).orElseThrow(()-> new ResourceNotFoundException("Category","Id",id));
		find.setCategoryTitle(dto.getCategoryTitle());
		find.setCategoryDescription(dto.getCategoryDescription());
		try {
			repo.save(find);
			return true;
		}catch(Exception e) {
			throw new JpaException("Category", "Update");
		}
		
		
	}

	//Delete-Category
	@Override
	public boolean delete(Integer id) {
		Category find = repo.findById(id).orElseThrow(()->new ResourceNotFoundException("Category","Id",id));
		try {
			repo.delete(find);
			return true;
		}catch(Exception e) {
			throw new JpaException("Category", "Delete");
		}
	}

}
