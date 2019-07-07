package com.csis3275.Boundary;

import java.util.ArrayList;

import com.csis3275.Entities.Reservation;
/**
 * Interface for ReservationDAO
 * @author Gahyun Lee 300289068
 *
 */
public interface ReservationDAO {

	/**
	 * A method creating new reservation and return its ID
	 * @param reservation
	 * @return reservationId
	 */
	public Integer createReservation(Reservation reservation);
	
	/**
	 * A method update reservation info and return if it was successful 
	 * @param reservation
	 * @return updated(boolean)
	 */
	public boolean updateReservation(Reservation reservation);
	
	/**
	 * A method deleting a specified reservation
	 * @param reservation
	 * @return deleted(boolean)
	 */
	public boolean deleteReservation(Reservation reservation);
	
	/**
	 * A method read reservation using reservationId and return reservation
	 * @param reservationId
	 * @return reservation
	 */
	public Reservation readReservation(Integer reservationId);
	
	/**
	 * A method getting list of all the reservations
	 * @return reservationsList
	 */
	public ArrayList<Reservation> readAllReservations();
}
