package com.airline.quantas.rest.webservices.quantasrestapiwebservices;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.*;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Collections;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.airline.quantas.rest.webservices.quantasrestapiwebservices.user.User;
import com.airline.quantas.rest.webservices.quantasrestapiwebservices.user.UserJPAResource;
import com.airline.quantas.rest.webservices.quantasrestapiwebservices.user.UserRepository;

@RunWith(SpringRunner.class)
@WebMvcTest(UserRepository.class)
public class QuantasRestApiWebservicesApplicationUnitTests {
	
	@Autowired
	private MockMvc mockMvc;
	private UserJPAResource userJPAResource;
	
	@Test
	public void retrieveUserTest() throws Exception {
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		java.util.Date yourDate = sdf.parse("2018-05-24");
		
		when(userJPAResource.retrieveUser(1)).thenReturn((new User(10001,"AB",yourDate,"India","s@gmail.com")));
		
		RequestBuilder request=MockMvcRequestBuilders.get("/jpa/users/10001").accept(MediaType.APPLICATION_JSON);

		MvcResult result=mockMvc.perform(request)
				.andExpect(status().isOk())
				.andExpect(content().json("[{id:10001,name:AB,birthDate:2018-05-24T13:24:57.888+0000,home_address:India,email_address:s@gmail}]"))
				.andReturn();
	}
	
	@Test
	public void retrieveAllUserTest() throws Exception {
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		java.util.Date yourDate = sdf.parse("2018-05-24");
		
		when(userJPAResource.retrieveUser(1)).thenReturn(
				(User) Arrays.asList(new User(10001,"AB",yourDate,"India","s@gmail.com"),
						new User(10002,"Jill",yourDate,"UK","k@gmail.com");
		
		RequestBuilder request=MockMvcRequestBuilders.get("/jpa/users").accept(MediaType.APPLICATION_JSON);

		MvcResult result=mockMvc.perform(request)
				.andExpect(status().isOk())
				.andExpect(content().json("[{id:10002,name:Jill,birthDate:2018-05-24T13:24:57.888+0000,home_address:UK,email_address:k@gmail}]"))
				.andReturn();
	}

}

