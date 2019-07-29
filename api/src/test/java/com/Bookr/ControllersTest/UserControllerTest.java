/**
 * 
 */
package com.Bookr.ControllersTest;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
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

import com.Bookr.Controllers.UserController;
import com.Bookr.Entities.User;
import com.Bookr.Services.UserService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author Gahyun Lee 300289068
 *
 */
@RunWith(SpringRunner.class)
@ContextConfiguration(classes = {UserController.class})
@WebMvcTest(value=UserController.class)
public class UserControllerTest {
	
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private UserService userService;
	
	@Test
	public void testCreateUser() throws Exception {
		User user = new User();
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
	}


	@Test
	public void testGetUserById() throws Exception {
		
		User user = new User();
		user.set_role_id(1);
		user.set_firstname("Amber");
		user.set_lastname("Mclean");
		user.set_email("email@email.com");
		user.set_password("passwords");
		
		String URI = "/api/users/1";
		
		Mockito.when(userService.getById(Mockito.anyInt())).thenReturn(user);
		
		RequestBuilder requestBuilder = MockMvcRequestBuilders
				.get(URI)
				.accept(MediaType.APPLICATION_JSON);
		
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		
		String expectedJson = this.mapToJson(user);
		String outputInJson = result.getResponse().getContentAsString();
		
		assertEquals(expectedJson, outputInJson);
	}
	
	@Test
	public void testgetAllRooms() throws Exception {
		
		User user1 = new User();
		user1.set_role_id(1);
		user1.set_firstname("Amber");
		user1.set_lastname("Mclean");
		user1.set_email("email@email.com");
		user1.set_password("passwords");
		
		User user2 = new User();
		user2.set_role_id(1);
		user2.set_firstname("Anuar");
		user2.set_lastname("Muckhambetzhanov");
		user2.set_email("Anuar@email.com");
		user2.set_password("passwords12");
		
		List<User> userList = new ArrayList<>();
		userList.add(user1);
		userList.add(user2);
		
		Mockito.when(userService.findAll()).thenReturn(userList);
		
		String URI = "/api/users/all";
		
		RequestBuilder requestBuilder = MockMvcRequestBuilders
				.get(URI)
				.accept(MediaType.APPLICATION_JSON);
		
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		
		String expectedJson = this.mapToJson(userList);
		String outputInJson = result.getResponse().getContentAsString();
		
		assertEquals(expectedJson, outputInJson);
	}

	private String mapToJson(Object object) throws JsonProcessingException {
		ObjectMapper objectMapper = new ObjectMapper();
		return objectMapper.writeValueAsString(object);
	}
	
}
