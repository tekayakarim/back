package com.pfe.main.controller;

import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.pfe.main.entity.DemandeVoiture;
import com.pfe.main.model.entityConverter;
import com.pfe.main.service.DemandeDocumentService;
import com.pfe.main.service.DemandeVoitureService;

class DemandeVoitureControllerTest extends entityConverter{

	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	DemandeVoitureService demandeVoitureService;
	
	private String url="http://localhost:9000/main/demandeVoiture";
	
	private DemandeVoiture dem=new DemandeVoiture();
	
	@Test
	void testCreate() {
		try {
			
			when(demandeVoitureService.CreateDemande(dem)).thenReturn("success");
			
			this.mockMvc
			.perform(
					MockMvcRequestBuilders
					.post(url+"/add")
					.accept(MediaType.APPLICATION_JSON)
						.content(super.mapToJson(dem)))
					.andDo(print())
					.andExpect(status().isOk())
					.andExpect(content()
						.string(containsString("success")));
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}

	@Test
	void testGetLong() {
		try {
			
			when(demandeVoitureService.getDemande(dem.getId())).thenReturn(dem);
			
			this.mockMvc.perform(
					get(url+"/get")
					.param("id",String.valueOf( dem.getId())))
			.andDo(print())
			.andExpect(status().isOk())
			.andExpect(content().contentType(MediaType.APPLICATION_JSON));
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}

	@Test
	void testUpdateDemandeVoiture() {
	try {
			
			when(demandeVoitureService.updateDemande(dem)).thenReturn("success");
			
			this.mockMvc
			.perform(
					MockMvcRequestBuilders
					.put(url+"/update")
					.accept(MediaType.APPLICATION_JSON)
						.content(super.mapToJson(dem)))
					.andDo(print())
					.andExpect(status().isOk())
					.andExpect(content()
						.string(containsString("success")));
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}

	@Test
	void testGetAll() {
		try {
			
			when(demandeVoitureService.getAllDemande());
			
			this.mockMvc.perform(get(url+"/getAll"))
			.andDo(print())
			.andExpect(status().isOk())
			.andExpect(content().contentType(MediaType.APPLICATION_JSON));
		} catch (Exception e) {
		
			e.printStackTrace();
		}
	}

	@Test
	void testDelete() {
	try {
			
			when(demandeVoitureService.deleteDemande(dem.getId())).thenReturn("success");
			
			this.mockMvc
			.perform(
					MockMvcRequestBuilders
					.delete(url+"/delete")
					.param("id", String.valueOf(dem.getId())))
					.andDo(print())
					.andExpect(status().isOk())
					.andExpect(content()
						.string(containsString("success")));
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}

	@Test
	void testGetByCurrentUser() {
		try {
			when(demandeVoitureService.getAllDemandeByEmploye(dem.getEmp().getUserName()));
			
			this.mockMvc.perform(get(url+"/getByCurrentUser")
					.param("userName", dem.getEmp().getUserName()))
			.andDo(print())
			.andExpect(status().isOk())
			.andExpect(content().contentType(MediaType.APPLICATION_JSON));
		} catch (Exception e) {
		
			e.printStackTrace();
		}
	}

	@Test
	void testUpdateLong() {
		try {
			when(demandeVoitureService.rendreVoiture(dem.getId()));
			
			this.mockMvc.perform(put(url+"/rendreVoiture")
					.param("idDemande", String.valueOf(dem.getId())))
			.andDo(print())
			.andExpect(status().isOk())
			.andExpect(content().string("voiture rendu"));
		} catch (Exception e) {
		
			e.printStackTrace();
		}
	}

	@Test
	void testGetDemandeInProgressByCurrentUser() {
		try {
			when(demandeVoitureService
					.getDemandeInProgressByCurrentUser(dem.getEmp().getUserName()));
			
			this.mockMvc.perform(get(url+"/getDemandeInProgressByCurrentUser")
					.param("userName", dem.getEmp().getUserName()))
			.andDo(print())
			.andExpect(status().isOk())
			.andExpect(content().contentType(MediaType.APPLICATION_JSON));
		} catch (Exception e) {
		
			e.printStackTrace();
		}
	}

}
