package com.Bookr.SystemTest;

import static org.junit.Assert.*;
import static org.mockito.Mockito.times;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

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
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.Bookr.Controllers.ReservationController;
import com.Bookr.Controllers.UserController;
import com.Bookr.Entities.Reservation;
import com.Bookr.Entities.User;
import com.Bookr.Services.ReservationService;
import com.Bookr.Services.UserService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
/**
 * @author Gahyun Lee 300289068
 * System Test - A System test using JUnit for the CRUDoperations for at least one Entity class. 
 * You must use the same Database Access class that your main application uses
 */
@RunWith(SpringRunner.class)
@ContextConfiguration(classes = {ReservationController.class, UserController.class})
@WebMvcTest(value=ReservationController.class)
public class SystemTest {
	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private ReservationService reservationService;
	@MockBean
	private UserService userService;

	@Test
	public void test() throws Exception {
		
		/* Create User and Check it */
		User user = new User();
		user.setId(1);
		user.set_role_id(1);
		user.set_firstname("Amber");
		user.set_lastname("Mclean");
		user.set_email("email@email.com");
		user.set_password("passwords");
		
		String inputInJson = this.mapToJson(user);
		String URI = "/api/users/create_user";
		
		Mockito.when(userService.saveOrUpdateUser(Mockito.any(User.class))).thenReturn(user);
		
		RequestBuilder requestBuilder = MockMvcRequestBuilders
				.post(URI)
				.accept(MediaType.APPLICATION_JSON).content(inputInJson)
				.contentType(MediaType.APPLICATION_JSON);
		
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		MockHttpServletResponse response = result.getResponse();
		String outputInJson = response.getContentAsString();
		
		assertEquals(inputInJson, outputInJson);
		assertEquals(HttpStatus.CREATED.value(), response.getStatus());
		
		
		/* Get User By ID*/
		String URI3 = "/api/users/1";
		
		Mockito.when(userService.getById(Mockito.anyInt())).thenReturn(user);
		
		RequestBuilder requestBuilder3 = MockMvcRequestBuilders
				.get(URI3)
				.accept(MediaType.APPLICATION_JSON);
		
		MvcResult result3 = mockMvc.perform(requestBuilder3).andReturn();
		
		String expectedJson = this.mapToJson(user);
		String outputInJson3 = result3.getResponse().getContentAsString();
		
		assertEquals(expectedJson, outputInJson3);
		
		
		/* Get All Users */
		User user2 = new User();
		user2.set_role_id(1);
		user2.set_firstname("Anuar");
		user2.set_lastname("Muckhambetzhanov");
		user2.set_email("Anuar@email.com");
		user2.set_password("passwords12");
		
		List<User> userList = new ArrayList<>();
		userList.add(user);
		userList.add(user2);
		
		Mockito.when(userService.findAll()).thenReturn(userList);
		
		String URI4 = "/api/users/all";
		
		RequestBuilder requestBuilder4 = MockMvcRequestBuilders
				.get(URI4)
				.accept(MediaType.APPLICATION_JSON);
		
		MvcResult result4 = mockMvc.perform(requestBuilder4).andReturn();
		
		String expectedJson4 = this.mapToJson(userList);
		String outputInJson4 = result4.getResponse().getContentAsString();
		
		assertEquals(expectedJson4, outputInJson4);
		
		
		
		/* Create Reservation using created User */
		Reservation reservation = new Reservation();
		reservation.set_user_id(user.getId());
		reservation.set_room_id(1);
		reservation.set_res_number("2019072801");
		
		// Setting start date
		Calendar cal = Calendar.getInstance();
		cal.set(2019, Calendar.JULY, 25, 10, 10, 20);
		Date date = cal.getTime();
		reservation.set_start_date(date);
		// Setting end date
		Calendar cal2 = Calendar.getInstance();
		cal2.set(2019, Calendar.JULY, 26, 10, 10, 20);
		Date date2 = cal2.getTime();
		reservation.set_end_date(date2);

		String inputInJson2 = this.mapToJson(reservation);
		String URI2 = "/api/reservations/create_reservation";
		
		Mockito.when(reservationService.saveOrUpdateReservation(Mockito.any(Reservation.class))).thenReturn(reservation);
		
		RequestBuilder requestBuilder2 = MockMvcRequestBuilders
				.post(URI2)
				.accept(MediaType.APPLICATION_JSON).content(inputInJson2)
				.contentType(MediaType.APPLICATION_JSON);
		
		MvcResult result2 = mockMvc.perform(requestBuilder2).andReturn();
		System.out.println(result2);

		MockHttpServletResponse response2 = result2.getResponse();
		System.out.println(response2);
		
		String outputInJson2 = response2.getContentAsString();
		
		assertEquals(inputInJson2, outputInJson2);
		assertEquals(HttpStatus.CREATED.value(), response2.getStatus());
		
		
		/* Delete User*/

		Mockito.when(userService.getById(1)).thenReturn(user);
		userService.delete(1);
		Mockito.verify(userService, times(1)).delete(1);

	}
	
	private String mapToJson(Object object) throws JsonProcessingException {
		ObjectMapper objectMapper = new ObjectMapper();
		return objectMapper.writeValueAsString(object);
	}

}
