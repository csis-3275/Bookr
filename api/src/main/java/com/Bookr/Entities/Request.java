/**
 * 
 */
package com.Bookr.Entities;

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

import com.Bookr.Utilities.DateAndTimeDeserialize;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

/**
 * @author Ayodeji Tolu-ojo 300249754
 */

@Entity
@Table(name="requests")
public class Request {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name="user_id")
	private Integer _user_id;

	@Column(name="title")
	private String _title;
	
	@Column(name="message")
	private String _message;
	
	@Column(name="date_sent")
	private String _date_sent;
	
	
	
	

	/**
	 * @return the _title
	 */
	public String get_title() {
		return _title;
	}

	/**
	 * @param _title the _title to set
	 */
	public void set_title(String _title) {
		this._title = _title;
	}

	/**
	 * @return the _user_id
	 */
	public Integer get_user_id() {
		return _user_id;
	}

	/**
	 * @param _user_id the _user_id to set
	 */
	public void set_user_id(Integer _user_id) {
		this._user_id = _user_id;
	}

	/**
	 * @return the _message
	 */
	public String get_message() {
		return _message;
	}

	/**
	 * @param _message the _message to set
	 */
	public void set_message(String _message) {
		this._message = _message;
	}

	/**
	 * @return the _date_sent
	 */
	public String get_date_sent() {
		return _date_sent;
	}

	/**
	 * @param _date_sent the _date_sent to set
	 */
	public void set_date_sent(String _date_sent) {
		this._date_sent = _date_sent;
	}
}
