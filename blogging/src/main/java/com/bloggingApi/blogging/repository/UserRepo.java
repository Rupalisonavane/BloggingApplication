package com.bloggingApi.blogging.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bloggingApi.blogging.modal.User;

public interface UserRepo extends JpaRepository<User, Integer> {

	
}
