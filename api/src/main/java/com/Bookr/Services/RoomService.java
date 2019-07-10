/**
 * 
 */
package com.Bookr.Services;

import org.springframework.beans.factory.annotation.Autowired;

import com.Bookr.Boundaries.RoomRepository;
import com.Bookr.Entities.Room;

/**
 * @author Ayodeji Tolu-ojo 300249754
 *
 */
public class RoomService {
	@Autowired
	private RoomRepository roomRepository;
	
	public Room saveOrUpdateRoom(Room room)
	{
		return roomRepository.save(room);
	}
	
	public Iterable<Room> findAll(){
		return roomRepository.findAll();
	}
}
