/**
 * 
 */
package com.Bookr.Boundaries;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.Bookr.Entities.Request;

/**
 * @author Ayodeji Tolu-ojo 300249754
 *
 */
@Repository
public interface RequestsRepository extends CrudRepository<Request, Integer> {
	
	public Request getById(Integer id);
}
