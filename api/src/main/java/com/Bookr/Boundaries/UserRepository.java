/**
 * 
 */
package com.bookr.Boundaries;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.Bookr.Entities.User;

public class UserRepository {

/**
 * @author Minh Dinh 300286942
 *
 */

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {
	public User getById(Integer Id);
}
