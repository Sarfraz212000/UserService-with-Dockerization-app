package com.example.demo.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.UserDto;
import com.example.demo.service.UserService;

@RestController
public class UserRestControler {

	@Autowired
	private UserService services;

	@PostMapping("/save")
	public ResponseEntity<String> createUser(@RequestBody UserDto dto) {
		boolean status = services.saveUser(dto);

		if (status) {
			return new ResponseEntity<>("User save sucessfully", HttpStatus.OK);
		} else {
			return new ResponseEntity<>("Failed to save the user", HttpStatus.INTERNAL_SERVER_ERROR);

		}
	}

	@GetMapping("/users")
	public ResponseEntity<List<UserDto>> getAllUsers() {
		List<UserDto> allUser = services.getAllUser();
		return new ResponseEntity<>(allUser, HttpStatus.OK);
	}
	
	@PutMapping("/user/{id}")
	public ResponseEntity<UserDto> updateUser(@RequestBody UserDto userDto,@PathVariable Long id){
		UserDto updateUser = services.updateUser(userDto, id);
		return new ResponseEntity<>(updateUser, HttpStatus.OK);

	}
	
	@GetMapping("/{id}")
	public ResponseEntity<UserDto> getByUserId(@PathVariable Long id) {
		  UserDto user = services.getById(id);
		return new ResponseEntity<>(user, HttpStatus.OK);
	}
	
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteUser(@PathVariable Long id) {
		boolean status = services.deleteUserById(id);

		if (status) {
			return new ResponseEntity<>("delete sucessfully", HttpStatus.OK);
		} else {
			return new ResponseEntity<>("Failed to delete the user", HttpStatus.INTERNAL_SERVER_ERROR);

		}
	}	
	
	

}
