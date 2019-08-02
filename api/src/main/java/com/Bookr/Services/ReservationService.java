/**
 * 
 */
package com.Bookr.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Bookr.Boundaries.ReservationRepository;
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
	
	public void delete(Integer id) {
		Reservation reservation = getById(id);
		reservationRepository.delete(reservation);
	}
	
	public Iterable<Reservation> findByUser(Integer user_id)
	{
		return reservationRepository.findByUserId(user_id);
	}
}
