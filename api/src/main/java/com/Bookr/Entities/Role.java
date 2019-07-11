/**
 * 
 */
package com.Bookr.Entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 * @author Ayodeji Tolu-ojo 300249754
 *
 */

@Entity
@Table(name="users")
public class Role {
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	@OneToMany(mappedBy="_user")
	@NotNull
	private List<User> _users;
}
