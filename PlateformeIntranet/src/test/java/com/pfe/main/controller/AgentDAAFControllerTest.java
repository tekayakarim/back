package com.pfe.main.controller;

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

import com.pfe.main.model.entityConverter;
import com.pfe.main.service.AgentDAAFService;

class AgentDAAFControllerTest extends entityConverter{
	
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	AgentDAAFService agentDAAFService;
	
	private String url="http://localhost:9000/main/agentDAAF";
	
	/*private DemandeDocument dem = new DemandeDocument(1
			 ,"description"
			 ,"type"
			 ,"new"
			 ,"francais"
			 ,new Employe("employe",
					 "employe"));*/
	
	@Test
	void testToDo() {
		try {
			
			when(agentDAAFService.getDemandeToDo("agentDAAF"));
			
			this.mockMvc
			.perform(
					MockMvcRequestBuilders
					.get(url+"/demandeToDo")
					.param("userName","agentDAAF"))
					.andDo(print())
					.andExpect(status().isOk())
					.andExpect(content().contentType(MediaType.APPLICATION_JSON));
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}

	@Test
	void testGetTask() {
	try {
			
			when(agentDAAFService.getTaskToDo("agentDAAF"));
			
			this.mockMvc
			.perform(
					MockMvcRequestBuilders
					.get(url+"/taskToDo")
					.param("userName","agentDAAF"))
					.andDo(print())
					.andExpect(status().isOk())
					.andExpect(content().contentType(MediaType.APPLICATION_JSON));
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}



	@Test
	void testGetAgent() {
	try {
			
		when(agentDAAFService.getAgent(16));
			
			this.mockMvc
			.perform(
					MockMvcRequestBuilders
					.get(url+"/getAgent")
					.param("id",String.valueOf(16)))
					.andDo(print())
					.andExpect(status().isOk())
					.andExpect(content().contentType(MediaType.APPLICATION_JSON));
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}

	@Test
	void testGetAgentByUserName() {
		try {
			
			when(agentDAAFService.getAgentByUserName("agentDAAF"));
				
				this.mockMvc
				.perform(
						MockMvcRequestBuilders
						.get(url+"/getAgentByUserName")
						.param("userName","agentDAAF"))
						.andDo(print())
						.andExpect(status().isOk())
						.andExpect(content().contentType(MediaType.APPLICATION_JSON));
				
			} catch (Exception e) {
				
				e.printStackTrace();
			}
	}

}
