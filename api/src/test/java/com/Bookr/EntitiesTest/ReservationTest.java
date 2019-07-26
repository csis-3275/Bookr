package com.Bookr.EntitiesTest;

import static org.junit.Assert.*;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
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
		
		// Setting start date
		 Calendar cal = Calendar.getInstance();
		 cal.set(2019, Calendar.JULY, 25, 10, 10, 20);
		 Date date = cal.getTime();
		 DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");  
         nr.set_start_date(date);
         
        // Setting end date
		 Calendar cal2 = Calendar.getInstance();
		 cal2.set(2019, Calendar.JULY, 26, 10, 10, 20);
		 Date date2 = cal2.getTime();
		 nr.set_end_date(date2);

		nr.set_res_number("123456");
		
		//Test
		assertEquals(1, nr.get_room_id().intValue());
		assertEquals(1, nr.get_user_id().intValue());
		
		assertEquals(dateFormat.format(date), nr.get_start_date());
		assertEquals("2019-07-25 10:10:20", nr.get_start_date());
		assertEquals(dateFormat.format(date2), nr.get_end_date());

		assertEquals("123456", nr.get_res_number());
		
		// Status Change
		nr.set_room_id(3);
		nr.set_user_id(10);
		
		cal2.set(2019, Calendar.JUNE, 30, 11, 10, 20);
		Date date3 = cal2.getTime();
		nr.set_end_date(date3);
        nr.set_start_date(date3);
        
		cal.set(2019, Calendar.JULY, 10, 01, 10, 20);
		Date date4 = cal.getTime();
		nr.set_end_date(date4);
        nr.set_end_date(date4);

		nr.set_res_number("201906301");

		//Test
		assertEquals(3, nr.get_room_id().intValue());
		assertEquals(10, nr.get_user_id().intValue());
		
		assertEquals("2019-06-30 11:10:20", nr.get_start_date());
		assertEquals("2019-07-10 01:10:20", nr.get_end_date());

		assertEquals("201906301", nr.get_res_number());
		
	}
}
