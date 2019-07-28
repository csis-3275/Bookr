/**
 * 
 */
package com.Bookr.ControllersTest;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.Bookr.Controllers.ReservationController;
import com.Bookr.Controllers.RoomController;
import com.Bookr.Controllers.UserController;
import com.Bookr.Entities.Reservation;
import com.Bookr.Entities.Room;
import com.Bookr.Entities.User;
import com.Bookr.Services.RoomService;
import com.Bookr.Services.UserService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author Gahyun Lee 300289068
 *
 */
@RunWith(SpringRunner.class)
@ContextConfiguration(classes = {RoomController.class})
@WebMvcTest(value=RoomController.class)
public class RoomControllerTest {
	
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private RoomService roomService;
	
	@Test
	public void testGetRoomByID() throws Exception {
		
		Room room = new Room();
		room.set_availability("available");
		room.set_maximum_capacity(5);
		room.set_room_number(101);
		room.set_type("meetingroom");
		
		String URI = "/api/rooms/1";
		
		Mockito.when(roomService.getById(Mockito.anyInt())).thenReturn(room);
		
		RequestBuilder requestBuilder = MockMvcRequestBuilders
				.get(URI)
				.accept(MediaType.APPLICATION_JSON);
		
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		
		String expectedJson = this.mapToJson(room);
		String outputInJson = result.getResponse().getContentAsString();
		
		assertEquals(expectedJson, outputInJson);
	}
	
	@Test
	public void testgetAllRooms() throws Exception {
		
		Room room1 = new Room();
		room1.set_availability("available");
		room1.set_maximum_capacity(5);
		room1.set_room_number(101);
		room1.set_type("meetingroom");
		
		Room room2 = new Room();
		room2.set_availability("available");
		room2.set_maximum_capacity(5);
		room2.set_room_number(201);
		room2.set_type("meetingroom");
		
		List<Room> roomList = new ArrayList<>();
		roomList.add(room1);
		roomList.add(room2);
		
		Mockito.when(roomService.findAll()).thenReturn(roomList);
		
		String URI = "/api/rooms/all";
		
		RequestBuilder requestBuilder = MockMvcRequestBuilders
				.get(URI)
				.accept(MediaType.APPLICATION_JSON);
		
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		
		String expectedJson = this.mapToJson(roomList);
		String outputInJson = result.getResponse().getContentAsString();
		
		assertEquals(expectedJson, outputInJson);
	}

	private String mapToJson(Object object) throws JsonProcessingException {
		ObjectMapper objectMapper = new ObjectMapper();
		return objectMapper.writeValueAsString(object);
	}
	
}
