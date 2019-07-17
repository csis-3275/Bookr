/**
 * 
 */
package com.Bookr.Boundaries;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.Bookr.Entities.User;

/**
 * @author Minh Dinh 300286942
 *
 */
@Repository
public interface UserRepository extends CrudRepository<User, Integer> {
	public User getById(Integer Id);
}
