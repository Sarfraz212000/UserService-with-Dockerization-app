package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.UserDto;

public interface UserService {

	boolean saveUser(UserDto dto);

	List<UserDto> getAllUser();

	UserDto getById(Long id);

	UserDto updateUser(UserDto userDto, Long id);
	
	boolean deleteUserById(Long id);

}
