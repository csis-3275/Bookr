/**
 * 
 */
package com.Bookr.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Bookr.Entities.Room;
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
	
	@GetMapping("/all") // get all rooms
	public Iterable getAllRooms(){
		return roomService.findAll();
	}
	
	@GetMapping("/{room_id}") // get one room based on id
	public ResponseEntity<?> getRoomById(@PathVariable Integer room_id)
	{
		Room new_room = roomService.getById(room_id);
		
		return new ResponseEntity<Room>(new_room, HttpStatus.OK);
	}
}
