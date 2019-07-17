/**
 * 
 */
package com.Bookr.Services;

import org.springframework.stereotype.Service;

import com.Bookr.Boundaries.RoleRepository;
import com.Bookr.Entities.UserRole;

/**
 * @author Ayodeji Tolu-ojo
 *
 */

@Service
public class RoleService {
	
	private RoleRepository roleRepository;
	
	public UserRole getById(Integer id)
	{
		return roleRepository.getById(id);
	}
	
	public Iterable<UserRole> findAllRoles()
	{
		return roleRepository.findAll();
	}
}
