/**
 * 
 */
package com.Bookr.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Bookr.Services.RoomService;

/**
 * @author Ayodeji Tolu-ojo 300249754
 *
 */

@RestController
@RequestMapping("/api/rooms")
@CrossOrigin
public class RoomController {
	@Autowired
	
	private RoomService roomService;
	
	@GetMapping("/all")
	public Iterable getAllRooms(){
		return roomService.findAll();
	}
}
