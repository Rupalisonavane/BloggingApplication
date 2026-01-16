package com.bloggingApi.blogging.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bloggingApi.blogging.exceptions.ResourceNotFoundException;
import com.bloggingApi.blogging.modal.User;
import com.bloggingApi.blogging.payloads.UserDto;
import com.bloggingApi.blogging.repository.UserRepo;
import com.bloggingApi.blogging.services.UserService;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepo userRepo;

	@Override
	public UserDto createUser(UserDto userDto) {

		User user=this.dtoToUser(userDto);
		User createdUser=this.userRepo.save(user);
		return this.userToDto(createdUser);
	}

	@Override
	public UserDto upadateUser(UserDto userDto, Integer id) {
       User user=this.userRepo.findById(id).orElseThrow(()-> new ResourceNotFoundException("user", "id", id));
		user.setEmail(userDto.getEmail());
		user.setAbout(userDto.getAbout());
		user.setName(userDto.getName());
		user.setPassword(userDto.getPassword());
		user.setId(userDto.getId());
		User updatedUser=this.userRepo.save(user);
		UserDto userDto1=this.userToDto(updatedUser);
       return userDto1;
	}

	@Override
	public UserDto getUserById(Integer id) {
		// TODO Auto-generated method stub
	       User user=this.userRepo.findById(id).orElseThrow(()-> new ResourceNotFoundException("user", "id", id));

		return this.userToDto(user);
	}

	@Override
	public List<UserDto> getAllUSers() {
		// TODO Auto-generated method stub
        List<User> users = this.userRepo.findAll();
     List<UserDto> userDto=   users.stream().map(user->this.userToDto(user)).collect(Collectors.toList());
		return userDto;
	}

	@Override
	public void deleteUser(Integer id) {
    User uder= this.userRepo.findById(id).orElseThrow(()-> new ResourceNotFoundException("user", "id", id));	
	   this.userRepo.delete(uder);
	}
	
	public User dtoToUser(UserDto userDto)
	{
		User user=new User();
		user.setEmail(userDto.getEmail());
		user.setName(userDto.getName());
		user.setAbout(userDto.getAbout());
		user.setId(userDto.getId());
		user.setPassword(userDto.getPassword());
		return user;
	}
	public UserDto userToDto(User user)
	{
		UserDto userDto=new UserDto();
		userDto.setEmail(user.getEmail());
		userDto.setName(user.getName());
		userDto.setId(user.getId());
		
		return userDto;
	}

}
