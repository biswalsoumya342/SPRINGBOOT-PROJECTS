package com.soumya.blogapp.mapper;

import org.mapstruct.Mapper;

import com.soumya.blogapp.entities.User;
import com.soumya.blogapp.payloads.UserDto;

@Mapper(componentModel = "spring")
public interface UserMapper {
	UserDto toDto(User user);
	User toUser(UserDto userDto);
}
