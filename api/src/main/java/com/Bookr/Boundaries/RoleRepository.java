/**
 * 
 */
package com.Bookr.Boundaries;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.Bookr.Entities.UserRole;

/**
 * @author Ayodeji Tolu-ojo 300249754
 *
 */

@Repository
public interface RoleRepository extends CrudRepository<UserRole, Integer> {
	public UserRole getById(Integer id);
}
