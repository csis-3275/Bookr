/**
 * 
 */
package com.Bookr.Entities;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @author Ayodeji Tolu-ojo 300249754
 *
 */

@Entity
@Table(name="users")
public class User {
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	@NotNull
	@OneToMany(mappedBy="_user")
	private List<Reservation> _reservations;
	
	@ManyToOne(targetEntity=Role.class)
	@JoinColumn(name="role_id", referencedColumnName="id")
	@NotNull
	private Role _role;
	
	@NotBlank
	@Column(name="firstname")
	private Date _firstname;
	
	@NotBlank
	@Column(name="lastname")
	private Date _lastname;
	
	@NotBlank
	@Column(name="email")
	private String email;
}
