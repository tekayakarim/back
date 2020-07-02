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

import com.pfe.main.entity.DemandeDocument;
import com.pfe.main.entity.Employe;
import com.pfe.main.service.ChefDAAFService;

class ChefDAAFControllerTest {

	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	ChefDAAFService chefDAAFService;
	
	private String url="http://localhost:9000/main/chefDAAF";
	
	private DemandeDocument dem = new DemandeDocument(1
	 ,"description"
	 ,"type"
	 ,"new"
	 ,"francais"
	 ,new Employe("employe",
			 "employe"));
	
	@Test
	void testGetAllDemande() {
		try {
			
			when(chefDAAFService.getAllAcceptedDemande("chefDAAF"));
			
			this.mockMvc
			.perform(
					MockMvcRequestBuilders
					.get(url+"/getAllAcceptedDemandeDocument")
					.param("userName","chefDAAF"))
					.andDo(print())
					.andExpect(status().isOk())
					.andExpect(content().contentType(MediaType.APPLICATION_JSON));
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}

	@Test
	void testGetAllAgentLibre() {
		try {
			
			when(chefDAAFService.listerAgentDemandeNull("chefDAAF"));
			
			this.mockMvc
			.perform(
					MockMvcRequestBuilders
					.get(url+"/getAllAgentLibreByChef")
					.param("userName","chefDAAF"))
					.andDo(print())
					.andExpect(status().isOk())
					.andExpect(content().contentType(MediaType.APPLICATION_JSON));
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}

	@Test
	void testConfier() {
		try {
			
			when(chefDAAFService.ConfierDemande(dem.getId(), 1));
			
			this.mockMvc
			.perform(
					MockMvcRequestBuilders
					.post(url+"/confierDemande")
					.param("idDemande",String.valueOf(dem.getId()))
					.param("idAgent", String.valueOf(1)))
					.andDo(print())
					.andExpect(status().isOk())
					.andExpect(content().contentType(MediaType.TEXT_PLAIN));
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}

	@Test
	void testGetAllChef() {
		try {
			
			when(chefDAAFService.listerAllChefDAAF());
			
			this.mockMvc
			.perform(
					MockMvcRequestBuilders
					.get(url+"/getAllChefDAAF"))
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
			
			when(chefDAAFService.getChefByCin("chefDAAF"));
			
			this.mockMvc
			.perform(
					MockMvcRequestBuilders
					.get(url+"/getChefDAAFByCin")
					.param("cin", "chefDAAF"))
					.andDo(print())
					.andExpect(status().isOk())
					.andExpect(content().contentType(MediaType.APPLICATION_JSON));
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}

}
