package com.bloggingApi.blogging.services;

import java.util.List;

import com.bloggingApi.blogging.payloads.UserDto;

public interface UserService {

	UserDto createUser(UserDto user);
	UserDto upadateUser(UserDto user,Integer id);
	UserDto getUserById(Integer id);
	List<UserDto> getAllUSers();
	void deleteUser(Integer id);
}
