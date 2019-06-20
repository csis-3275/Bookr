package com.csis3275.Entities;

import javax.persistence.Id;
import javax.persistence.GeneratedValue;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="reservations")

/**
 * @author Ayodeji Tolu-ojo 300249754
 *
 */

public class Reservation {
	@Id
	@GeneratedValue
	private int _id;
	private int _room_id;
	private Date _start_date;
	private Date _end_date;
	private int _status;
	private String _reservation_number;
	
	/**
	 * @return the reservation_number
	 */
	public String getReservation_number() {
		return _reservation_number;
	}

	/**
	 * @param reservation_number the reservation_number to set
	 */
	public void setReservation_number(String reservation_number) {
		this._reservation_number = reservation_number;
	}

	public Reservation() {
		
	}

	/**
	 * @return the _room_id
	 */
	public int get_room_id() {
		return _room_id;
	}

	/**
	 * @param _room_id the _room_id to set
	 */
	public void set_room_id(int _room_id) {
		this._room_id = _room_id;
	}

	/**
	 * @return the _start_date
	 */
	public Date get_start_date() {
		return _start_date;
	}

	/**
	 * @param _start_date the _start_date to set
	 */
	public void set_start_date(Date _start_date) {
		this._start_date = _start_date;
	}

	/**
	 * @return the _end_date
	 */
	public Date get_end_date() {
		return _end_date;
	}

	/**
	 * @param _end_date the _end_date to set
	 */
	public void set_end_date(Date _end_date) {
		this._end_date = _end_date;
	}

	/**
	 * @return the _status
	 */
	public int get_status() {
		return _status;
	}

	/**
	 * @param _status the _status to set
	 */
	public void set_status(int _status) {
		this._status = _status;
	}

	/**
	 * @return the _id
	 */
	public int get_id() {
		return _id;
	}
	
	
}
