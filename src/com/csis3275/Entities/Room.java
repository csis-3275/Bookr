/**
 * 
 */
package com.csis3275.Entities;

import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="rooms")

/**
 * @author Ayodeji Tolu-ojo 300249754
 *
 */

public class Room {
	@Id
	@GeneratedValue
	private int _id;
	private int _type;
	private int _room_number;
	private int _maximum_capacity;
	private int _availability;
	
	public Room() {
		
	}
	
	/**
	 * @return the _type
	 */
	public int get_type() {
		return _type;
	}
	/**
	 * @param _type the _type to set
	 */
	public void set_type(int _type) {
		this._type = _type;
	}
	/**
	 * @return the _room_number
	 */
	public int get_room_number() {
		return _room_number;
	}
	/**
	 * @param _room_number the _room_number to set
	 */
	public void set_room_number(int _room_number) {
		this._room_number = _room_number;
	}
	/**
	 * @return the _maximum_capacity
	 */
	public int get_maximum_capacity() {
		return _maximum_capacity;
	}
	/**
	 * @param _maximum_capacity the _maximum_capacity to set
	 */
	public void set_maximum_capacity(int _maximum_capacity) {
		this._maximum_capacity = _maximum_capacity;
	}
	/**
	 * @return the _availability
	 */
	public int get_availability() {
		return _availability;
	}
	/**
	 * @param _availability the _availability to set
	 */
	public void set_availability(int _availability) {
		this._availability = _availability;
	}
	/**
	 * @return the _id
	 */
	public int get_id() {
		return _id;
	}
}
