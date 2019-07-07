package com.csis3275.Boundary;

import java.util.ArrayList;

import com.csis3275.Entities.Room;
/**
 * Interface of RoomDAO
 * @author Gahyun Lee 300289068
 *
 */
public interface RoomDAO {
	
	/**
	 * A method creating new room and return its ID
	 * @param room
	 * @return roomId
	 */
	public Integer createRoom(Room room);
	
	/**
	 * A method update room info and return if it was successful
	 * @param room
	 * @return updated(boolean)
	 */
	public boolean updateRoom(Room room);
	
	/**
	 * A method read room using roomId and return Room
	 * @param roomId
	 * @return room
	 */
	public Room readRoom(Integer roomId);
	
	/**
	 * A method deleting a specified room
	 * @param room
	 * @return deleted(boolean)
	 */
	public boolean deleteRoom(Room room);
	
	/**
	 * A method getting list of all the rooms;
	 * @return RoomsList
	 */
	public ArrayList<Room> readAllRooms();
}
