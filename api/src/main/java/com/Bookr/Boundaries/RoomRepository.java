/**
 * 
 */
package com.Bookr.Boundaries;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.Bookr.Entities.Room;

/**
 * @author Ayodeji Tolu-ojo 300249754
 *
 */
@Repository
public interface RoomRepository extends CrudRepository<Room, Integer> {
	
}
