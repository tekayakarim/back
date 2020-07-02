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
import com.pfe.main.service.ChefHierarchiqueService;

class ChefHierarchiqueControllerTest {
	
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	ChefHierarchiqueService chefHierarchiqueService;
	
	private String url="http://localhost:9000/main/chefHierarchique";
	
	private DemandeDocument dem = new DemandeDocument(1
			 ,"description"
			 ,"type"
			 ,"new"
			 ,"francais"
			 ,new Employe("employe",
					 "employe"));
	
	@Test
	void testGetAllDemandeDocument() {
		try {
			
			when(chefHierarchiqueService.getAllNewDemandeDocument("chefHie"));
			
			this.mockMvc
			.perform(
					MockMvcRequestBuilders
					.get(url+"/getAllDemandeDocument")
					.param("userName","chefHie"))
					.andDo(print())
					.andExpect(status().isOk())
					.andExpect(content().contentType(MediaType.APPLICATION_JSON));
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}

	}

	@Test
	void testUpdateDemandeDocumentStatut() {
		try {
			
			when(chefHierarchiqueService.updateDemandeDocument(dem.getId(), "new"));
			
			this.mockMvc
			.perform(
					MockMvcRequestBuilders
					.put(url+"/updateStatutDemandeDocument")
					.param("id",String.valueOf(dem.getId()))
					.param("statut", "new"))
					.andDo(print())
					.andExpect(status().isOk())
					.andExpect(content().string("updated"));
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}

	@Test
	void testGetAllChef() {
		try {
			
			when(chefHierarchiqueService.listerAllChefHie());
			
			this.mockMvc
			.perform(
					MockMvcRequestBuilders
					.get(url+"/getAllChefHierarchique"))
					.andDo(print())
					.andExpect(status().isOk())
					.andExpect(content().contentType(MediaType.APPLICATION_JSON));
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}

	@Test
	void testGetAllDemandeVoiture() {
		try {
			
			when(chefHierarchiqueService.getAllDemandeVoiture("chefHie"));
			
			this.mockMvc
			.perform(
					MockMvcRequestBuilders
					.get(url+"/getAllDemandeVoiture")
					.param("userName","chefHie"))
					.andDo(print())
					.andExpect(status().isOk())
					.andExpect(content().contentType(MediaType.APPLICATION_JSON));
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}

	@Test
	void testUpdateDemandeVoitureStatut() {
		try {
			
			when(chefHierarchiqueService.updateDemandeVoiture(dem.getId(), "new"));
			
			this.mockMvc
			.perform(
					MockMvcRequestBuilders
					.put(url+"/updateStatutDemandeVoiture")
					.param("id",String.valueOf(dem.getId()))
					.param("statut", "new"))
					.andDo(print())
					.andExpect(status().isOk())
					.andExpect(content().string("updated"));
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}

	@Test
	void testGetByCin() {
		try {
			
			when(chefHierarchiqueService.getCin("chefHie"));
			
			this.mockMvc
			.perform(
					MockMvcRequestBuilders
					.put(url+"/getChefHierarchiqueByCin")
					.param("cin","chefHie"))
					.andDo(print())
					.andExpect(status().isOk())
					.andExpect(content().contentType(MediaType.APPLICATION_JSON));
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}

}
