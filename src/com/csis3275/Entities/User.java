package com.csis3275.Entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="users")

/**
 * @author Ayodeji Tolu-ojo 300249754
 *
 */

public class User {
	@Id
	@GeneratedValue
	private int _id;
	private int _role_id;
	private String _firstname;
	private String _lastname;
	private String _email;
	
	public User() {
		
	}
	
	/**
	 * @return the _role_id
	 */
	public int get_role_id() {
		return _role_id;
	}
	/**
	 * @param _role_id the _role_id to set
	 */
	public void set_role_id(int _role_id) {
		this._role_id = _role_id;
	}
	/**
	 * @return the _firstname
	 */
	public String get_firstname() {
		return _firstname;
	}
	/**
	 * @param _firstname the _firstname to set
	 */
	public void set_firstname(String _firstname) {
		this._firstname = _firstname;
	}
	/**
	 * @return the _lastname
	 */
	public String get_lastname() {
		return _lastname;
	}
	/**
	 * @param _lastname the _lastname to set
	 */
	public void set_lastname(String _lastname) {
		this._lastname = _lastname;
	}
	/**
	 * @return the _email
	 */
	public String get_email() {
		return _email;
	}
	/**
	 * @param _email the _email to set
	 */
	public void set_email(String _email) {
		this._email = _email;
	}
	/**
	 * @return the _id
	 */
	public int get_id() {
		return _id;
	}
	
	
	
}
