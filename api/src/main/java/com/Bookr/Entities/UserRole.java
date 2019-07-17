/**
 * 
 */
package com.Bookr.Entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * @author Ayodeji Tolu-ojo 300249754
 *
 */

@Entity
@Table(name="roles")
public class UserRole {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@OneToMany(targetEntity=User.class,cascade=CascadeType.ALL, fetch = FetchType.LAZY)
	@NotNull
	@JsonIgnore
	@JoinColumn(name="role_id", referencedColumnName="id", insertable=false, updatable=false)
	private List<User> _users;
	
	@Column(name="name")
	@NotBlank(message="Roll name cannot be blank")
	private String _name;
	
}
