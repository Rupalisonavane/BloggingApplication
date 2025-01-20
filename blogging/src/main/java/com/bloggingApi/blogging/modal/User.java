package com.bloggingApi.blogging.modal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class User {
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
 private long id;
 @Column(name="username",nullable = false,length=100)
 private String name;
 private String email;
 private String password;
 private String about;
}

