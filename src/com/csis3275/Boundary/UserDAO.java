package com.csis3275.Boundary;

import java.util.ArrayList;

import com.csis3275.Entities.User;

public interface UserDAO {
	
	public Integer createUser(User user);
	public boolean updateUser(User user);
	public boolean deleteUser(User user);
	public User readUser(Integer userId);
	public ArrayList<User> readAllUser();
}
