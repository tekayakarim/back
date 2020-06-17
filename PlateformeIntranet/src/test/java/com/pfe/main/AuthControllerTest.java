package com.pfe.main;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.pfe.main.controller.AuthController;

@WebMvcTest(AuthController.class)
public class AuthControllerTest {

	@Autowired
	private MockMvc mockMvc;
	
	@WithMockUser
	@Test
	public void authenticateUserShouldReturnAuthentificatedUser() throws Exception {
	this.mockMvc.perform(MockMvcRequestBuilders.post("auth/signin").accept(MediaType.APPLICATION_JSON))
	.andExpect(status().isOk());
	
	}
}
