package com.csis3275.Entities;

import javax.persistence.Id;
import javax.persistence.GeneratedValue;

import java.util.Vector;

import javax.persistence.Column;
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
	@Column(name="id")
	private int _id;
	
	@Column(name="room_id")
	private int _room_id;
	
	@Column(name="date")
	private String _date;
	
	@Column(name="time")
	private String _time;

	@Column(name="status")
	private String _status;
	
	@Column(name="res_number")
	private String _reservation_number;
	
	public Reservation() {
		
	}
	
	/**
	 * @return the _time
	 */
	public String get_time() {
		return _time;
	}

	/**
	 * @param _time the _time to set
	 */
	public void set_time(String _time) {
		this._time = _time;
	}

	/**
	 * @return the _reservation_number
	 */
	public String get_reservation_number() {
		return _reservation_number;
	}

	/**
	 * @param _reservation_number the _reservation_number to set
	 */
	public void set_reservation_number(String _reservation_number) {
		this._reservation_number = _reservation_number;
	}


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
	public String get_date() {
		return _date;
	}

	/**
	 * @param _date the _date to set
	 */
	public void set_date(String _date) {
		this._date = _date;
	}

	/**
	 * @return the _status
	 */
	public String get_status() {
		return _status;
	}

	/**
	 * @param _status the _status to set
	 */
	public void set_status(String _status) {
		this._status = _status;
	}

	/**
	 * @return the _id
	 */
	public int get_id() {
		return _id;
	}
	
	public Vector getVector() {
		Vector v = new Vector();
		v.add(_id);
		v.add(_room_id);
		v.add(_date);
		v.add(_time);
		v.add(_reservation_number);
		
		return v;
	}
	
}
