package com.myclass.service;

import java.util.List;

import com.myclass.dto.UserDto;

public interface UserService {

	void insert(UserDto userDto);

	List<UserDto> getAll();

	void update(int id, UserDto userDto);

	void delete(int id);

	UserDto getById(int id);

	UserDto getByPhone(String phone);

	
}
