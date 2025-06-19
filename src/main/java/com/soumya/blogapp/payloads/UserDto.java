package com.soumya.blogapp.payloads;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {
	
	private Integer userId;
	
	@NotEmpty(message="UserName Must Not Be Empty")
	@Size(min = 3,message = "User Name Must Be 3 Character Long")
	private String name;
	
	@Email(message = "Enter Valid EMail!")
	private String email;
	
	@NotEmpty(message="PassWord Must Not Be Empty")
	@Size(min = 8,message = "Password Must Be 8 Character Long")
	private String password;
	
	@NotEmpty(message="About Must Not Be Empty")
	@Size(min = 5,message = "About Must Be 5 Character Long")
	private String about;
}
