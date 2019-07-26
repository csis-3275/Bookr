/**
 * 
 */
package com.Bookr.EntitiesTest;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.Bookr.Entities.Reservation;
import com.Bookr.Entities.Room;

/**
 * @author Gahyun Lee 300289068
 *
 */
public class RoomTest {

	@Test
	public void roomTest() {
		// Create a room
		Room nr = new Room();
		
		nr.set_type("conference");
		nr.set_room_number(100);
		nr.set_maximum_capacity(50);
		nr.set_availability("available");
		
		//create a reservation
		Reservation resv = new Reservation();
		nr.add_reservations(resv); //null point exception sloved
		
		//create list with resv
		List<Reservation> reservList= new ArrayList<>(); 
		reservList.add(resv);
		
		// Check Room info
		assertEquals("conference", nr.get_type());
		assertEquals(100, nr.get_room_number().intValue());
		assertEquals(50, nr.get_maximum_capacity().intValue());
		assertEquals("available", nr.get_availability());
		assertArrayEquals(reservList.toArray(), nr.get_reservations());
		
		// state changes
		nr.set_type("workspace");
		nr.set_room_number(200);
		nr.set_maximum_capacity(5);
		nr.set_availability("notavailable");
		
		Reservation resv2 = new Reservation();
		reservList.add(resv2);
		nr.add_reservations(resv2); 


		//Test
		assertEquals("workspace", nr.get_type());
		assertEquals(200, nr.get_room_number().intValue());
		assertEquals(5, nr.get_maximum_capacity().intValue());
		assertEquals("notavailable", nr.get_availability());
		assertArrayEquals(reservList.toArray(), nr.get_reservations());

		
	}

}
