/**
 * 
 */
package com.Bookr.Entities;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 * @author Ayodeji Tolu-ojo 300249754
 *
 */

@Entity
@Table(name="reservations")
public class Reservation {
	
	SimpleDateFormat sdf = new SimpleDateFormat("yyy-MM-dd HH:mm:ss");
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	@ManyToOne(targetEntity=Room.class)
	@JoinColumn(name="room_id", referencedColumnName="id")
	@NotNull
	private Room _room;
	
	@Column(name="start_date")
	private Date _start_date;
	
	@Column(name="end_date")
	private Date _end_date;
	
	@Column(name="status")
	private String _status;
	
	@Column(name="reservation_number")
	private String _res_number;
	
	/**
	 * @return the _room_id
	 */
	public Room get_room() {
		return _room;
	}

	/**
	 * @param _room_id the _room_id to set
	 */
	public void set_room_id(Room _room) {
		this._room = _room;
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
	 * @return the _res_number
	 */
	public String get_res_number() {
		return _res_number;
	}

	/**
	 * @param _res_number the _res_number to set
	 */
	public void set_res_number(String _res_number) {
		this._res_number = _res_number;
	}

	/**
	 * @return the _id
	 */
	public Integer get_id() {
		return id;
	}

	public Reservation() {
		
	}
}
