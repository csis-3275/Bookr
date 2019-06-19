package com.csis3275.Boundary;

import com.csis3275.Entities.Reservation;

public interface ReservationDAO {

	public Integer createReservation(Reservation reservation);
	public boolean updateReservation(Reservation reservation);
}
