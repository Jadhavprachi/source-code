package com.project.service;

import java.util.List;

import com.project.model.User;

public interface UserService {

	public Boolean createUser(User userModel);
	public List<User> listUser();
	public User getUser(int userId);
	public Boolean authenticateUser(User userModel);
	public Boolean deleteUser(int userId);
	public boolean editUser(User userModel);
}
