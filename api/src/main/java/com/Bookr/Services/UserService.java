/**
 * 
 */
package com.Bookr.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Bookr.Boundaries.UserRepository;
import com.Bookr.Entities.User;

/**
 * @author Minh Dinh 300286942
 *
 */
@Service
public class UserService {
	@Autowired
	private UserRepository userRepository;
	
	public User saveOrUpdateUser(User user) {
		return userRepository.save(user);
	}
	
	public Iterable<User> findAll() {
		return userRepository.findAll();
	}
	
	public User getById(Integer id) {
		return userRepository.getById(id);
	}
	
	public void delete(Integer id) {
		User user = getById(id);
		userRepository.delete(user);
	}
}
