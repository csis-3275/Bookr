/**
 * 
 */
package com.Bookr.Boundaries;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.Bookr.Entities.User;

/**
 * @author Minh Dinh 300286942
 *
 */
@Repository
public interface UserRepository extends CrudRepository<User, Integer> {
	@Query(value = "SELECT * FROM users WHERE email = ?1 AND password = ?2", nativeQuery = true)
	public User findByEmailAddressAndPassword(String email, String password);
	
	
	public User getById(Integer Id);
	
}
