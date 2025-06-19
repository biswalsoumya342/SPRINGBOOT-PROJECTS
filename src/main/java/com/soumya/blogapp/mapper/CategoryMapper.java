package com.soumya.blogapp.mapper;



import org.mapstruct.Mapper;

import com.soumya.blogapp.entities.Category;
import com.soumya.blogapp.payloads.CategoryDto;

@Mapper(componentModel = "spring")
public interface CategoryMapper {
	public Category toCategory(CategoryDto categoryDto);
	public CategoryDto toCategoryDto(Category category);
}
