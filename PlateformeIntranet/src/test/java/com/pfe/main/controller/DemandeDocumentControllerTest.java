package com.pfe.main.controller;

import static org.hamcrest.CoreMatchers.containsString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
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
import com.pfe.main.model.entityConverter;
import com.pfe.main.service.DemandeDocumentService;

class DemandeDocumentControllerTest extends entityConverter{

	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	DemandeDocumentService demandeDocumentService;
	
	private String url="http://localhost:9000/main/demandeDocument";
	
	DemandeDocument dem = new DemandeDocument(1
											 ,"description"
											 ,"type"
											 ,"new"
											 ,"francais"
											 ,new Employe("employe",
													 "employe"));
	@Test
	void testCreate() {
		try {
			
			when(demandeDocumentService.CreateDemande(dem)).thenReturn("success");
			
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
			
			when(demandeDocumentService.getDemande(dem.getId())).thenReturn(dem);
			
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
	void testUpdate() {
	try {
			
			when(demandeDocumentService.updateDemande(dem)).thenReturn("success");
			
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
			
			when(demandeDocumentService.getAllDemande());
			
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
			
			when(demandeDocumentService.deleteDemande(dem.getId())).thenReturn("success");
			
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
			when(demandeDocumentService.getAllDemandeByEmploye(dem.getEmp().getUserName()));
			
			this.mockMvc.perform(get(url+"/getByCurrentUser")
					.param("userName", dem.getEmp().getUserName()))
			.andDo(print())
			.andExpect(status().isOk())
			.andExpect(content().contentType(MediaType.APPLICATION_JSON));
		} catch (Exception e) {
		
			e.printStackTrace();
		}
	}

}
