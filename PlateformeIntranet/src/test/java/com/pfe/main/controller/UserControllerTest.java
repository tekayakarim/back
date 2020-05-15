package com.pfe.main.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;

import com.pfe.main.service.EmployeService;
class UserControllerTest {
	
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	EmployeService employeService;
/*	@BeforeEach
	public void setup() {
		Employe emp=new Employe();
		when(employeService.getEmploye(emp.getUserName())).thenReturn(emp);
	}*/
	@WithMockUser(roles="EMPLOYE")
	@Test
	void testGetUserEmploye() throws Exception {
		this.mockMvc.perform(get("/main/user/getCurrentUserEmploye"))
		.andDo(print())
		.andExpect(status().isOk())
		.andExpect(content().contentType(MediaType.APPLICATION_JSON));
	}

}
