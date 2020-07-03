package com.pfe.main.controller;

import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.pfe.main.model.MailModel;
import com.pfe.main.service.DemandeVoitureService;
import com.pfe.main.service.EmployeService;
import com.pfe.main.service.UserService;

//@WebMvcTest(UserController.class)
class UserControllerTest {

	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	EmployeService employeService;

	@MockBean
	UserService userService;
	
	private String url="http://localhost:9000/main/user";
	
	@Test
	void testGetUserEmployeString() {
	try {
			
			when(employeService.getEmploye("employe"));
			
			this.mockMvc
			.perform(
					MockMvcRequestBuilders
					.get(url+"/getCurrentUserEmploye")
					.param("userName", "employe"))
					.andDo(print())
					.andExpect(status().isOk())
					.andExpect(content()
						.contentType(MediaType.APPLICATION_JSON));
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}

	@Test
	void testGetAllUsers() {
	try {
			
			when(userService.listerAllUsers());
			
			this.mockMvc
			.perform(
					MockMvcRequestBuilders
					.get(url+"/getAllUsers"))
					.andDo(print())
					.andExpect(status().isOk())
					.andExpect(content()
						.contentType(MediaType.APPLICATION_JSON));
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}


	@Test
	void testGetUserEmployeLong() {
	try {
			
			when(userService.getUserById(5));
			
			this.mockMvc
			.perform(
					MockMvcRequestBuilders
					.get(url+"/getCurrentUser")
					.param("id", String.valueOf(5)))
					.andDo(print())
					.andExpect(status().isOk())
					.andExpect(content()
						.contentType(MediaType.APPLICATION_JSON));
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}

}
