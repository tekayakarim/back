package com.pfe.main.controller;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

//@WebMvcTest(AuthController.class)
 class AuthControllerTest {
	
	@Autowired
	private MockMvc mockMvc;
	
	@WithMockUser
	@Test
	 void testAuthenticateUser()  {
		try {
			this.mockMvc
			.perform(
					MockMvcRequestBuilders
					.post("http://localhost:9000/auth/signin")
					.accept(MediaType.APPLICATION_JSON))
			.andDo(print())
			.andExpect(status().isOk())
			.andExpect(content().contentType(MediaType.APPLICATION_JSON));
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}
	@WithMockUser
	@Test
	void testRegisterUser() {
		try {
			this.mockMvc
			.perform(
					MockMvcRequestBuilders
					.post("http://localhost:9000/auth/signup")
					.accept(MediaType.APPLICATION_JSON))
			.andDo(print())
			.andExpect(status().isOk())
			.andExpect(content().contentType(MediaType.APPLICATION_JSON));
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}

}
