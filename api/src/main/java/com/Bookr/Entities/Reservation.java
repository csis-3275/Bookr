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
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * @author Ayodeji Tolu-ojo 300249754
 *
 */

@Entity
@Table(name="reservations")
public class Reservation {
	
	SimpleDateFormat sdf = new SimpleDateFormat("yyy-MM-dd HH:mm:ss");
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@ManyToOne(targetEntity=Room.class)
	@JoinColumn(name="room_id", referencedColumnName="id")
	@NotNull
	@JsonIgnore
	private Room _room;
	
	@ManyToOne(targetEntity=User.class)
	@JoinColumn(name="user_id", referencedColumnName="id")
	@JsonIgnore
	private User _user;
	
	@NotNull
	@Column(name="start_date")
	private String _start_date;
	
	@NotNull
	@Column(name="end_date")
	private String _end_date;
	
	@NotEmpty
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
	public String get_start_date() {
		return _start_date;
	}

	/**
	 * @param _start_date the _start_date to set
	 */
	public void set_start_date(Date _start_date) {
		this._start_date = sdf.format(_start_date);
	}

	/**
	 * @return the _end_date
	 */
	public String get_end_date() {
		return _end_date;
	}

	/**
	 * @param _end_date the _end_date to set
	 */
	public void set_end_date(Date _end_date) {
		this._end_date = sdf.format(_end_date);
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
