package com.bloggingApi.blogging.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bloggingApi.blogging.dao.UserDao;
import com.bloggingApi.blogging.exceptions.ResourceNotFoundException;
import com.bloggingApi.blogging.modal.User;
import com.bloggingApi.blogging.payloads.UserDto;
import com.bloggingApi.blogging.services.UserService;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserDao userDao;

	@Override
	public UserDto createUser(UserDto userDto) {

		User user=this.dtoToUser(userDto);
		User createdUser=this.userDao.save(user);
		return this.userToDto(createdUser);
	}

	@Override
	public UserDto upadateUser(UserDto userDto, Integer id) {
       User user=this.userDao.findById(id).orElseThrow(()-> new ResourceNotFoundException("user", "id", id));
		user.setEmail(userDto.getEmail());
		user.setAbout(userDto.getAbout());
		user.setName(userDto.getName());
		user.setPassword(userDto.getPassword());
		user.setId(userDto.getId());
		User updatedUser=this.userDao.save(user);
		UserDto userDto1=this.userToDto(updatedUser);
       return userDto1;
	}

	@Override
	public UserDto getUserById(Integer id) {
		// TODO Auto-generated method stub
	       User user=this.userDao.findById(id).orElseThrow(()-> new ResourceNotFoundException("user", "id", id));

		return this.userToDto(user);
	}

	@Override
	public List<UserDto> getAllUSers() {
		// TODO Auto-generated method stub
        List<User> users = this.userDao.findAll();
     List<UserDto> userDto=   users.stream().map(user->this.userToDto(user)).collect(Collectors.toList());
		return userDto;
	}

	@Override
	public void deleteUser(Integer id) {
    User uder= this.userDao.findById(id).orElseThrow(()-> new ResourceNotFoundException("user", "id", id));	
	   this.userDao.delete(uder);
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
