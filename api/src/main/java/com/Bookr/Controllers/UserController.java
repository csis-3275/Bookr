/**
 * 
 */
package com.Bookr.Controllers;

import java.util.HashMap;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Bookr.Entities.UserRole;
import com.Bookr.Entities.LoginDetails;
import com.Bookr.Entities.User;
import com.Bookr.Services.RoleService;
import com.Bookr.Services.UserService;

/**
 * @author Ayodeji Tolu-ojo 300249754
 *
 */

@RestController
@RequestMapping("/api/users")
@CrossOrigin("http://localhost:3000")
public class UserController {
	@Autowired
	private UserService userService;
	private RoleService roleService;
	
	@GetMapping("/all")
	private Iterable<User> getAllUsers()
	{
		return userService.findAll();
	}
	
	@GetMapping("/all_roles")
	private Iterable<UserRole> getAllRoles()
	{
		return roleService.findAllRoles();
	}
	
	@PostMapping("/login")
	private ResponseEntity<?> login(@Valid @RequestBody LoginDetails details)
	{
		User user = userService.findByEmailAndPassword(details.get_username(), details.get_password());
		return new ResponseEntity<User>(user, HttpStatus.OK);
	}
	
	@GetMapping("/{user_id}")
	private ResponseEntity<?> getUserById(@PathVariable Integer user_id)
	{
		User user = userService.getById(user_id);
		return new ResponseEntity<User>(user, HttpStatus.OK);
	}	
	
	@PostMapping("/create_user")
	private ResponseEntity<?> createNewUser(@Valid @RequestBody User user) 
	{
//		user.set_role(3);
		User new_user = userService.saveOrUpdateUser(user);
		return new ResponseEntity<User>(new_user, HttpStatus.CREATED);
	}
	
	
	@DeleteMapping("/delete/{user_id}")
	public ResponseEntity<?> deleteItem(@PathVariable Integer user_id){
		userService.delete(user_id);
		
		return new ResponseEntity<String>("User has been deleted", HttpStatus.OK);
	}
}
