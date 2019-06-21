package com.csis3275.Boundary;

import java.util.ArrayList;

import com.csis3275.Entities.Reservation;

public interface ReservationDAO {

	public Integer createReservation(Reservation reservation);
	public boolean updateReservation(Reservation reservation);
	public boolean deleteReservation(Reservation reservation);
	public Reservation readReservation(Integer reservationId);
	public ArrayList<Reservation> readAllReservations();
}
