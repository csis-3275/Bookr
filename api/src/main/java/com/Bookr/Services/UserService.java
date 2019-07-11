/**
 * 
 */
package com.Bookr.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Minh Dinh 300286942
 *
 */
@Service
public class UserService {
	@Autowired
	Private UserRepository userRepository;
	
	public User saveOrUpdateUser(User user){
		return userRepository.save(user);
	}
	
	public Iterable<User> findAll(){
		return userRepository.findAll();
	}
	
	public User getById(Integer Id) {
		return userRepository.getById(id);
	}
}
