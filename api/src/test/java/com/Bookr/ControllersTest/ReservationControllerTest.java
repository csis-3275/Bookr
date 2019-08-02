/**
 * 
 */
package com.Bookr.ControllersTest;

import static org.junit.Assert.assertEquals;


import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.Bookr.Controllers.ReservationController;
import com.Bookr.Entities.Reservation;
import com.Bookr.Services.ReservationService;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

/**
 * @author Gahyun Lee 300289068
 *
 */
@RunWith(SpringRunner.class)
@ContextConfiguration(classes = {ReservationController.class})
@WebMvcTest(value=ReservationController.class)
public class ReservationControllerTest {
	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private ReservationService reservationService;
	
	@Test
	public void testCreateNewReservation() throws Exception {
		Reservation reservation = new Reservation();
		reservation.set_user_id(1);
		reservation.set_room_id(1);
		reservation.set_res_number("2019072801");
		
		// Setting start date
		Calendar cal = Calendar.getInstance();
		cal.set(2019, Calendar.JULY, 25, 10, 10, 20);
		Date date = cal.getTime();
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");  
		reservation.set_start_date(dateFormat.format(date));
		// Setting end date
		Calendar cal2 = Calendar.getInstance();
		cal2.set(2019, Calendar.JULY, 26, 10, 10, 20);
		Date date2 = cal2.getTime();
		reservation.set_end_date(dateFormat.format(date2));

		String inputInJson = this.mapToJson(reservation);
		String URI = "/api/reservations/create_reservation";
		
		Mockito.when(reservationService.saveOrUpdateReservation(Mockito.any(Reservation.class))).thenReturn(reservation);
		
		RequestBuilder requestBuilder = MockMvcRequestBuilders
				.post(URI)
				.accept(MediaType.APPLICATION_JSON).content(inputInJson)
				.contentType(MediaType.APPLICATION_JSON);
		
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		System.out.println(result);

		MockHttpServletResponse response = result.getResponse();
		System.out.println(response);
		
		String outputInJson = response.getContentAsString();
		
		assertEquals(inputInJson, outputInJson);
		assertEquals(HttpStatus.CREATED.value(), response.getStatus());
	}


	@Test
	public void testGetReservationById() throws Exception {
		
		Reservation reservation = new Reservation();
		reservation.set_user_id(1);
		reservation.set_room_id(1);
		reservation.set_res_number("2019072801");
		// Setting start date
		Calendar cal = Calendar.getInstance();
		cal.set(2019, Calendar.JULY, 25, 10, 10, 20);
		Date date = cal.getTime();
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");  
		reservation.set_start_date(dateFormat.format(date));
		// Setting end date
		Calendar cal2 = Calendar.getInstance();
		cal2.set(2019, Calendar.JULY, 26, 10, 10, 20);
		Date date2 = cal2.getTime();
		reservation.set_end_date(dateFormat.format(date2));
		
		String URI = "/api/reservations/1";
		
		Mockito.when(reservationService.getById(Mockito.anyInt())).thenReturn(reservation);
		
		RequestBuilder requestBuilder = MockMvcRequestBuilders
				.get(URI)
				.accept(MediaType.APPLICATION_JSON);
		
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		
		String expectedJson = this.mapToJson(reservation);
		String outputInJson = result.getResponse().getContentAsString();
		
		assertEquals(expectedJson, outputInJson);
	}
	
	@Test
	public void testGetAllReservations() throws Exception {
		
		Reservation reservation1 = new Reservation();
		reservation1.set_user_id(1);
		reservation1.set_room_id(1);
		reservation1.set_res_number("2019072801");
		// Setting start date
		Calendar cal = Calendar.getInstance();
		cal.set(2019, Calendar.JULY, 25, 10, 10, 20);
		Date date = cal.getTime();
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");  
		reservation1.set_start_date(dateFormat.format(date));
		// Setting end date
		Calendar cal2 = Calendar.getInstance();
		cal2.set(2019, Calendar.JULY, 26, 10, 10, 20);
		Date date2 = cal2.getTime();
		reservation1.set_end_date(dateFormat.format(date2));
		
		Reservation reservation2 = new Reservation();
		reservation2.set_user_id(2);
		reservation2.set_room_id(2);
		reservation2.set_res_number("2019072802");
		// Setting start date
		cal.set(2019, Calendar.JULY, 25, 10, 10, 20);
		Date date3 = cal.getTime();
		reservation2.set_start_date(dateFormat.format(date3));
		// Setting end date
		cal2.set(2019, Calendar.JULY, 26, 10, 10, 20);
		Date date4 = cal2.getTime();
		reservation2.set_end_date(dateFormat.format(date4));

		
		List<Reservation> reservationList = new ArrayList<>();
		reservationList.add(reservation1);
		reservationList.add(reservation2);
		
		Mockito.when(reservationService.findAll()).thenReturn(reservationList);
		
		String URI = "/api/reservations/all";
		
		RequestBuilder requestBuilder = MockMvcRequestBuilders
				.get(URI)
				.accept(MediaType.APPLICATION_JSON);
		
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		
		String expectedJson = this.mapToJson(reservationList);
		String outputInJson = result.getResponse().getContentAsString();
		
		assertEquals(expectedJson, outputInJson);
	}

	private String mapToJson(Object object) throws JsonProcessingException {
		ObjectMapper objectMapper = new ObjectMapper();
		return objectMapper.writeValueAsString(object);
	}
	
}

