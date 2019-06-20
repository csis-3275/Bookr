package com.csis3275.Entities;

import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="roles")

/**
 * @author Ayodeji Tolu-ojo 300249754
 *
 */

public class Role {
	@Id
	@GeneratedValue
	private int _id;
	private int _name;
	
	public Role() {
		
	}

	/**
	 * @return the _name
	 */
	public int get_name() {
		return _name;
	}

	/**
	 * @param _name the _name to set
	 */
	public void set_name(int _name) {
		this._name = _name;
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return _id;
	}
	
	
}
