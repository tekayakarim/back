package com.pfe.main.controller;

import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.pfe.main.model.MailModel;
import com.pfe.main.service.DemandeVoitureService;
import com.pfe.main.service.MailService;

class TestControllerTest {

	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	MailService mailService;
	
	private String url="http://localhost:9000/main";
	
	@Test
	void testSend() {
	try {
			
			when(mailService.sendSimpleMessage(new MailModel()));
			
			this.mockMvc
			.perform(
					MockMvcRequestBuilders
					.post(url+"/sendMail")
					.accept(MediaType.APPLICATION_JSON))
					.andDo(print())
					.andExpect(status().isOk())
					.andExpect(content()
						.string(containsString("sent")));
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}

}
