package com.soumya.blogapp.payloads;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CategoryDto {
	
	private Integer categoryId;
	
	@NotBlank(message ="Title Can't Be Empty!")
	@Size(min=5,message="Title Must Be Minimum 5 Character Long")
	private String categoryTitle;
	
	@NotBlank(message="Description Can't Be Empty!")
	@Size(min=5,message="Description Must Be Minimum 5 Character Long")
	private String categoryDescription;
}
