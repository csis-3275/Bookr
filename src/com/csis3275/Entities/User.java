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
	private int _lastsname;
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
	 * @return the _lastsname
	 */
	public int get_lastsname() {
		return _lastsname;
	}
	/**
	 * @param _lastsname the _lastsname to set
	 */
	public void set_lastsname(int _lastsname) {
		this._lastsname = _lastsname;
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
