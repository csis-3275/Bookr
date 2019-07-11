/**
 * 
 */
package com.Bookr.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Bookr.Boundaries.RoomRepository;
import com.Bookr.Entities.Reservation;

/**
 * @author Minh Dinh 300286942
 *
 */
@Service
public class ReservationService {
	@Autowired
	private ReservationRepository reservationRepository;
	
	public Reservation saveOrUpdateReservation(Reservation reservation) {
		return reservationRepository.save(reservation);
	}
	
	public Iterable<Reservation> findAll() {
		return reservationRepository.findAll();
	}
	
	public Reservation getById(Integer id) {
		return reservationRepository.getById(id);
	}
}
