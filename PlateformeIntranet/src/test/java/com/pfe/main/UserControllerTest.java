package com.pfe.main;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;

import com.pfe.main.controller.UserController;
import com.pfe.main.entity.Employe;
import com.pfe.main.entity.JwtUser;
import com.pfe.main.service.EmployeService;

@WebMvcTest(UserController.class)
public class UserControllerTest {
	
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	EmployeService employeService;
	@BeforeEach
	public void setup() {
		Employe emp=new Employe();
		when(employeService.getEmploye(emp.getUserName())).thenReturn(emp);
	}
	@WithMockUser(roles="EMPLOYE")
	@Test
	public void getUserEmploye() throws Exception{

		
	this.mockMvc.perform(get("/main/user/getCurrentUserEmploye"))
			.andDo(print())
			.andExpect(status().isOk())
			.andExpect(content().contentType(MediaType.APPLICATION_JSON));

		/*this.mockMvc.perform(get("/"))
		.andDo(print())
		.andExpect(status().isOk())
		.andExpect(content().string("hh"));	*/
			

	}
}
