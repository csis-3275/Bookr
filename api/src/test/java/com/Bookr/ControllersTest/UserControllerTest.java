/**
 * 
 */
package com.Bookr.ControllersTest;

import static org.junit.Assert.assertEquals;

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
		
		assertEquals(outputInJson, inputInJson);
		assertEquals(HttpStatus.CREATED.value(), response.getStatus());
	}

	private String mapToJson(Object object) throws JsonProcessingException {
		ObjectMapper objectMapper = new ObjectMapper();
		return objectMapper.writeValueAsString(object);
	}
	
}
