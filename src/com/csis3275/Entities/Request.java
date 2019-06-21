/**
 * 
 */
package com.csis3275.Entities;

import javax.persistence.Id;
import javax.persistence.GeneratedValue;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="requests")

/**
 * @author Ayodeji Tolu-ojo 300249754
 *
 */

public class Request {
	@Id
	@GeneratedValue
	private int _id;
	private int _user_id;
	private String _reservation_number;
	private Date _requested_on;
	private int _type;
	private String _message;
	
	public Request() {
		
	}
	
	/**
	 * @return the user_id
	 */
	public int getUser_id() {
		return _user_id;
	}
	/**
	 * @param user_id the user_id to set
	 */
	public void setUser_id(int user_id) {
		this._user_id = user_id;
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
	 * @return the requested_on
	 */
	public Date getRequested_on() {
		return _requested_on;
	}
	/**
	 * @param requested_on the requested_on to set
	 */
	public void setRequested_on(Date requested_on) {
		this._requested_on = requested_on;
	}
	/**
	 * @return the type
	 */
	public int getType() {
		return _type;
	}
	/**
	 * @param type the type to set
	 */
	public void setType(int type) {
		this._type = type;
	}
	/**
	 * @return the message
	 */
	public String getMessage() {
		return _message;
	}
	/**
	 * @param message the message to set
	 */
	public void setMessage(String message) {
		this._message = message;
	}
	/**
	 * @return the _id
	 */
	public int get_id() {
		return _id;
	}
}
