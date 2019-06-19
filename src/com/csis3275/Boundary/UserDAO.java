package com.csis3275.Boundary;

import com.csis3275.Entities.User;

public interface UserDAO {
	
	public Integer createUser(User user);
	public boolean updateUser(User user);
}
