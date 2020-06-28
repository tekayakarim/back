package com.pfe.main.controller;

import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.jupiter.api.Assertions.fail;
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
import com.pfe.main.model.entityConverter;
import com.pfe.main.service.DemandeDocumentService;

class DemandeDocumentControllerTest extends entityConverter{

	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	DemandeDocumentService demandeDocumentService;
	
	DemandeDocument dem = new DemandeDocument();
	@Test
	void testCreate() {
		try {
			
			when(demandeDocumentService.CreateDemande(dem)).thenReturn("success");
			
			this.mockMvc
			.perform(
					MockMvcRequestBuilders
					.post("http://localhost:9000//main/demandeDocument/add")
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
		fail("Not yet implemented");
	}

	@Test
	void testUpdate() {
		fail("Not yet implemented");
	}

	@Test
	void testGetAll() {
		try {
			this.mockMvc.perform(get("http://localhost:9000/main/demandeDocument/getAll"))
			.andDo(print())
			.andExpect(status().isOk())
			.andExpect(content().contentType(MediaType.APPLICATION_JSON));
		} catch (Exception e) {
		
			e.printStackTrace();
		}
	}

	@Test
	void testDelete() {
		fail("Not yet implemented");
	}

	@Test
	void testGetString() {
		fail("Not yet implemented");
	}

}
