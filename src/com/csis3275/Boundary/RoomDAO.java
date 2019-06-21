package com.csis3275.Boundary;

import java.util.ArrayList;

import com.csis3275.Entities.Room;

public interface RoomDAO {
	public Integer createRoom(Room room);
	public boolean updateRoom(Room room);
	public Room readRoom(Integer roomId);
	public boolean deleteRoom(Room room);
	public ArrayList<Room> readAllRooms();
}
