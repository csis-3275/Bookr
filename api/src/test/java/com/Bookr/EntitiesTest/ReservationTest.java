package com.Bookr.EntitiesTest;

import static org.junit.Assert.*;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Test;

import com.Bookr.Entities.Reservation;

/**
 * @author Gahyun Lee 300289068
 *
 */
public class ReservationTest {

	@Test
	public void reservationTest() {
		Reservation nr = new Reservation();
		nr.set_room_id(1);
		nr.set_user_id(1);
		
//		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//		Date sd = new Date(2019,07,25,10,11,12);
//
//		
//		nr.set_start_date(sd);
		
//		Date ed = new Date();
//		ed.setMonth(4);
//		ed.setYear(2019);
//		ed.setDate(26);
//		nr.set_end_date(ed);
//		
		nr.set_res_number("123456");
		
		assertEquals(1, nr.get_room_id().intValue());
		assertEquals(1, nr.get_user_id().intValue());
//		assertEquals(sdf.format(sd), nr.get_start_date());
//		assertEquals("2019-07-25 10:11:12", nr.get_start_date());

//		assertEquals(ed, nr.get_end_date());
		assertEquals("123456", nr.get_res_number());
		
		
		
	}
}
