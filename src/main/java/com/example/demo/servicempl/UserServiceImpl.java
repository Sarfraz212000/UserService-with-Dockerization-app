package com.example.demo.servicempl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.UserDto;
import com.example.demo.entity.UserEntity;
import com.example.demo.exception.UserNotFoundException;
import com.example.demo.repo.UserRepository;
import com.example.demo.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository repo;

	@Override
	public boolean saveUser(UserDto dto) {

		UserEntity entity = new UserEntity();
		BeanUtils.copyProperties(dto, entity);
		repo.save(entity);
		return true;

	}

	@Override
	public List<UserDto> getAllUser() {
		List<UserEntity> users = repo.findAll();

		ArrayList<UserDto> userDtos = new ArrayList<>();

		for (UserEntity entity : users) {

			UserDto dto = new UserDto();
			BeanUtils.copyProperties(entity, dto);
			userDtos.add(dto);

		}
		return userDtos;
	}

	@Override
	public UserDto getById(Long id) {
		UserEntity user = repo.findById(id)
				.orElseThrow(() -> new UserNotFoundException("User not found with id:" + id));
		UserDto userDto = new UserDto();
		BeanUtils.copyProperties(user, userDto);
		return userDto;

	}

	@Override
	public UserDto updateUser(UserDto userDto, Long id) {
		Optional<UserEntity> optionalUser = repo.findById(id);
		if (optionalUser.isPresent()) {
			UserEntity user = optionalUser.get();

			// Copy updated fields from DTO to Entity
			BeanUtils.copyProperties(userDto, user, "userId");
			UserEntity updateUser = repo.save(user);

			// here I am convert back to DTO
			UserDto dto = new UserDto();
			BeanUtils.copyProperties(updateUser, dto);
			return dto;

		}
		return null;
	}

	@Override
	public boolean deleteUserById(Long id) {
		repo.deleteById(id);
		return true;
	}

}
