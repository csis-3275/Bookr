package com.csis3275.Entities;

import javax.persistence.Id;
import javax.persistence.GeneratedValue;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="transactions")

/**
 * @author Ayodeji Tolu-ojo 300249754
 *
 */

public class BookingTransaction {
	@Id
	@GeneratedValue
	private int _id;
	private int _user_id;
	private Date _processed_on;
	private int _subscription_id;
	private int _reservation_id;
	private int _state;
	private int _type;
	private double _amount_paid;
	
	public BookingTransaction() {
		
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
	 * @return the processed_on
	 */
	public Date getProcessed_on() {
		return _processed_on;
	}

	/**
	 * @param processed_on the processed_on to set
	 */
	public void setProcessed_on(Date processed_on) {
		this._processed_on = processed_on;
	}

	/**
	 * @return the subscription_id
	 */
	public int getSubscription_id() {
		return _subscription_id;
	}

	/**
	 * @param subscription_id the subscription_id to set
	 */
	public void setSubscription_id(int subscription_id) {
		this._subscription_id = subscription_id;
	}

	/**
	 * @return the reservation_id
	 */
	public int getReservation_id() {
		return _reservation_id;
	}

	/**
	 * @param reservation_id the reservation_id to set
	 */
	public void setReservation_id(int reservation_id) {
		this._reservation_id = reservation_id;
	}

	/**
	 * @return the state
	 */
	public int getState() {
		return _state;
	}

	/**
	 * @param state the state to set
	 */
	public void setState(int state) {
		this._state = state;
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
	 * @return the amount_paid
	 */
	public double getAmount_paid() {
		return _amount_paid;
	}

	/**
	 * @param amount_paid the amount_paid to set
	 */
	public void setAmount_paid(double amount_paid) {
		this._amount_paid = amount_paid;
	}

	/**
	 * @return the _id
	 */
	public int get_id() {
		return _id;
	}
	
	
}
