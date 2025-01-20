package com.bloggingApi.blogging.services;

import java.util.List;

import com.bloggingApi.blogging.payloads.UserDto;

public interface UserService {

	UserDto createUser(UserDto user);
	UserDto upadateUser(UserDto user,Integer id);
	UserDto getUserById(UserDto user);
	List<UserDto> getListOfUser(List<UserDto> userList)
}
