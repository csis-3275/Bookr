/**
 * 
 */
package com.Bookr.Entities;

import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;

/**
 * @author Ayodeji Tolu-ojo 300249754
 *
 */

@Entity
@Table(name="rooms")
public class Room {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	
	@Column(name="type")
	private String _type;
	
	@NotNull
	@Column(name="room_number")
	private Integer _room_number;
	
	@NotNull
	@Column(name="max_capacity")
	private Integer _maximum_capacity;
	
	@NotEmpty
	@Column(name="availability")
	private String _availability;
	
	@OneToMany(targetEntity=Reservation.class,cascade=CascadeType.ALL, fetch = FetchType.LAZY)
	@NotNull
	@JsonIgnore
	@JoinColumn(name="room_id", referencedColumnName="id")
	private List<Reservation> _reservations = new ArrayList<>();
	
	public Room() {
		
	}
	
	public void add_reservations(Reservation reserve)
	{
		this._reservations.add(reserve);
	}
	
	public Object[] get_reservations()
	{
		return this._reservations.toArray();
	}
	
	public String get_type() {
		return _type;
	}

	public void set_type(String _type) {
		this._type = _type;
	}

	public Integer get_room_number() {
		return _room_number;
	}

	public void set_room_number(Integer _room_number) {
		this._room_number = _room_number;
	}

	public Integer get_maximum_capacity() {
		return _maximum_capacity;
	}

	public void set_maximum_capacity(Integer _maximum_capacity) {
		this._maximum_capacity = _maximum_capacity;
	}

	public String get_availability() {
		return _availability;
	}

	public void set_availability(String _availability) {
		this._availability = _availability;
	}

	public Integer get_id() {
		return id;
	}
}
