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

import com.Bookr.Entities.User;
import com.Bookr.Services.UserService;

/**
 * @author Ayodeji Tolu-ojo 300249754
 *
 */

@RestController
@RequestMapping("/api/users")
@CrossOrigin
public class UserController {
	@Autowired
	private UserService userService;
	
	@GetMapping("/all")
	private Iterable<User> getAllUsers()
	{
		return userService.findAll();
	}
	
	
	@GetMapping("/{user_id}")
	private ResponseEntity<?> getUserById(@PathVariable Integer user_id)
	{
		User user = userService.getById(user_id);
		return new ResponseEntity<User>(user, HttpStatus.OK);
	}
	
	
	@PostMapping("/create_user")
	private ResponseEntity<?> createNewUser(@Valid @RequestBody User user, BindingResult result) 
	{
		if(result.hasErrors())
		{
			Map<String, String> error_map = new HashMap<>();
			
			for(FieldError field_error: result.getFieldErrors()) 
			{
				error_map.put(field_error.getField(), field_error.getDefaultMessage());
			}
			
			return new ResponseEntity<Map<String, String>>(error_map, HttpStatus.BAD_REQUEST);
		}
		
		User new_user = userService.saveOrUpdateUser(user);
		return new ResponseEntity<User>(new_user, HttpStatus.CREATED);
	}
	
	
	@DeleteMapping("/delete/{user_id}")
	public ResponseEntity<?> deleteItem(@PathVariable Integer user_id){
		userService.delete(user_id);
		
		return new ResponseEntity<String>("User has been deleted", HttpStatus.OK);
	}
}
