package com.Bookr.EntitiesTest;

import static org.junit.Assert.*;

import org.junit.Test;

import com.Bookr.Entities.Reservation;
import com.Bookr.Entities.User;

/**
 * @author Gahyun Lee 300289068
 *
 */
public class UserTest {

	@Test
	public void userTest() {
		User nu = new User();
		
		Reservation rv = new Reservation();
		Reservation rv2 = new Reservation();
		nu.add_reservations(rv);
		nu.add_reservations(rv2);
		Reservation[] rvArr = new Reservation[] {rv, rv2};
		
		nu.set_role_id(1);
		nu.set_firstname("Amber");
		nu.set_lastname("Mclean");
		nu.set_email("AmberM@gmail.com");
		nu.set_password("password123");
		
		//test
		assertEquals(1, nu.get_role_id().intValue());
		assertEquals("Amber", nu.get_firstname());
		assertEquals("Mclean",nu.get_lastname());
		assertEquals("AmberM@gmail.com", nu.get_email());
		assertEquals("password123", nu.get_password());
		assertArrayEquals(rvArr, nu.get_reservations());
		
		// After Value changed
		nu.set_role_id(2);
		nu.set_firstname("Anuar");
		nu.set_lastname("Mukham");
		nu.set_email("anuarM@gmail.com");
		nu.set_password("pw123123");
		
		//test change
		assertEquals(2, nu.get_role_id().intValue());
		assertEquals("Anuar", nu.get_firstname());
		assertEquals("Mukham",nu.get_lastname());
		assertEquals("anuarM@gmail.com", nu.get_email());
		assertEquals("pw123123", nu.get_password());
	}

}
