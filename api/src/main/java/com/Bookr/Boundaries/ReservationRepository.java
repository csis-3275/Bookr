/**
 * 
 */
package com.Bookr.Boundaries;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.Bookr.Entities.Reservation;

/**
 * @author Minh Dinh 300286942
 *
 */
@Repository
public interface ReservationRepository extends CrudRepository<Reservation, Integer> {
	public Reservation getById(Integer Id);
}
