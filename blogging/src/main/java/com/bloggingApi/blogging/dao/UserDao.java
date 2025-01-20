package com.bloggingApi.blogging.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bloggingApi.blogging.modal.User;

public interface UserDao extends JpaRepository<User, Long> {

}
