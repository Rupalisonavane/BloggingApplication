package com.bloggingApi.blogging.payloads;

public class UserDto {
 private long id; 
 private String email;
  private String password;
  private String about;
  private String name;
public long getId() {
	return id;
}
public void setId(long id) {
	this.id = id;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public String getAbout() {
	return about;
}
public void setAbout(String about) {
	this.about = about;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}

  
}
