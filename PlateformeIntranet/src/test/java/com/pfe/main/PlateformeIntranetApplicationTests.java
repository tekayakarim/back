package com.pfe.main;

import static org.hamcrest.CoreMatchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@SpringBootTest
@AutoConfigureMockMvc
public class PlateformeIntranetApplicationTests {
	
	@Autowired
	private MockMvc mockMvc;
	
	@Test
	public void shouldReturn() throws Exception {
		this.mockMvc.perform(get("/main/all")).andDo(print()).andExpect(status().isOk())
		.andExpect(content().string(containsString("Public Content.")));
		
		this.mockMvc.perform(get("http://localhost:9000/main/demandeDocument/getAll"))
		.andDo(print())
		.andExpect(status().isOk())
		.andExpect(content().contentType(MediaType.APPLICATION_JSON));
	}
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
	void testGetAll() throws Exception {
		this.mockMvc.perform(get("http://localhost:9000/main/demandeDocument/getAll"))
		.andDo(print())
		.andExpect(status().isOk())
		.andExpect(content().contentType(MediaType.APPLICATION_JSON));
	}
	@WithMockUser(roles="EMPLOYE")
	@Test
	void testGetUserEmploye() throws Exception {
		this.mockMvc.perform(get("/main/user/getCurrentUserEmploye"))
		.andDo(print())
		.andExpect(status().isOk())
		.andExpect(content().contentType(MediaType.APPLICATION_JSON));
	}
	
	@WithMockUser
	@Test
	public void authenticateUserShouldReturnAuthentificatedUser() throws Exception {
	this.mockMvc.perform(MockMvcRequestBuilders.post("http://localhost:9000/auth/signin").accept(MediaType.APPLICATION_JSON))
	.andExpect(status().isOk());
	
	}
}
