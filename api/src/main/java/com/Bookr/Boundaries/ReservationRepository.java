/**
 * 
 */
package com.Bookr.Boundaries;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.Bookr.Entities.Reservation;
import com.Bookr.Entities.User;

/**
 * @author Minh Dinh 300286942
 *
 */
@Repository
public interface ReservationRepository extends CrudRepository<Reservation, Integer> {
	@Query(value = "SELECT * FROM reservations WHERE user_id = ?1", nativeQuery = true)
	public Iterable<Reservation> findByUserId(Integer user_id);
	
	public Reservation getById(Integer Id);
}
