package com.pfe.main.controller;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

class AuthControllerTest {
	@Autowired
	private MockMvc mockMvc;
	@Test
	void testAuthenticateUser() throws Exception {
		this.mockMvc
		.perform(
				MockMvcRequestBuilders
				.post("/auth/signin")
				.accept(MediaType.APPLICATION_JSON))
		.andExpect(status().isOk());
	}

	@Test
	void testRegisterUser() {
		fail("Not yet implemented");
	}

}
