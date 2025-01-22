package com.bloggingApi.blogging.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bloggingApi.blogging.payloads.UserDto;
import com.bloggingApi.blogging.services.UserService;

@RestController
@RequestMapping("/blogging-api/users")
public class UserController {

	@Autowired
	private UserService userService;
	
	@GetMapping("/")
	public ResponseEntity<?> CreateUser(UserDto userDto)
	{
		UserDto CreatedUser=this.userService.createUser(userDto);
		return new ResponseEntity<>(CreatedUser,HttpStatus.CREATED);
		
	}
}
