package com.csis3275.Boundary;

import java.util.ArrayList;

import com.csis3275.Entities.User;
/**
 * Interface of UserDAO
 * @author Gahyun Lee 300289068
 *
 */
public interface UserDAO {
	
	/**
	 * A method creating new user and return its ID
	 * @param user
	 * @return userId
	 */
	public Integer createUser(User user);
	
	/**
	 * A method update user info and return if it was successful
	 * @param user
	 * @return updated(boolean)
	 */
	public boolean updateUser(User user);
	
	/**
	 * A method deleting a specified reservation
	 * @param user
	 * @return deleted(boolean)
	 */
	public boolean deleteUser(User user);
	
	/**
	 * A method read user using userId and return user
	 * @param userId
	 * @return user
	 */
	public User readUser(Integer userId);
	
	/**
	 * A method getting list of all the users
	 * @return usersList
	 */
	public ArrayList<User> readAllUser();
}
