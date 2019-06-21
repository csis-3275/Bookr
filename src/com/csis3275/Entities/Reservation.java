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
	private Date _date;
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
	 * @return the _date
	 */
	public Date get_date() {
		return _date;
	}

	/**
	 * @param _date the _date to set
	 */
	public void set_date(Date _date) {
		this._date = _date;
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
