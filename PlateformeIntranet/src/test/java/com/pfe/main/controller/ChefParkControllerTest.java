package com.pfe.main.controller;

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

import com.pfe.main.entity.DemandeDocument;
import com.pfe.main.entity.DemandeVoiture;
import com.pfe.main.entity.Employe;
import com.pfe.main.entity.Voiture;
import com.pfe.main.service.ChefHierarchiqueService;
import com.pfe.main.service.ChefParkService;

class ChefParkControllerTest {

	
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	ChefParkService chefParkService;
	
	private String url="http://localhost:9000/main/chefPark";
	

	private DemandeVoiture dem=new DemandeVoiture();
	private Voiture voi=new Voiture();
	
	@Test
	void testAddVoiture() {
		try {
			
			when(chefParkService.ajouterVoiture("chefPark", new Voiture()));
			
			this.mockMvc
			.perform(
					MockMvcRequestBuilders
					.post(url+"/addVoiture")
					.param("userName","chefPark")
					.accept(MediaType.APPLICATION_JSON))
					.andDo(print())
					.andExpect(status().isOk())
					.andExpect(content()
						.string("voiture ajouter a la base et a la liste des voitures du chef"));
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}

	@Test
	void testGetAllDemande() {
		try {
			
			when(chefParkService.getAllAcceptedDemande("chefPark"));
			
			this.mockMvc
			.perform(
					MockMvcRequestBuilders
					.post(url+"/getAllAcceptedDemandeVoiture")
					.param("userName","chefPark"))
					.andDo(print())
					.andExpect(status().isOk())
					.andExpect(content().contentType(MediaType.APPLICATION_JSON));
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}

	@Test
	void testGetAllVoiture() {
		try {
			
			when(chefParkService.getAllVoiture("chefPark"));
			
			this.mockMvc
			.perform(
					MockMvcRequestBuilders
					.post(url+"/getAllVoiture")
					.param("userName","chefPark"))
					.andDo(print())
					.andExpect(status().isOk())
					.andExpect(content().contentType(MediaType.APPLICATION_JSON));
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}


	@Test
	void testGetVoitureDispoByCurrentChefPark() {
		try {
			
			when(chefParkService.getVoitureDispoByCurrentChefPark("chefPark"));
			
			this.mockMvc
			.perform(
					MockMvcRequestBuilders
					.post(url+"/getAllVoitureDispo")
					.param("userName","chefPark"))
					.andDo(print())
					.andExpect(status().isOk())
					.andExpect(content().contentType(MediaType.APPLICATION_JSON));
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}

	@Test
	void testAssign() {
	try {
			
			when(chefParkService.assginVoiture(voi.getId(), dem.getId()));
			
			this.mockMvc
			.perform(
					MockMvcRequestBuilders
					.post(url+"/assignVoiture")
					.param("idVoiture",String.valueOf(voi.getId()))
					.param("idDemande", String.valueOf(dem.getId())))
					.andDo(print())
					.andExpect(status().isOk())
					.andExpect(content().contentType(MediaType.APPLICATION_JSON));
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}

	@Test
	void testGetHistoriqueDemandeVoitureByCurrentChef() {
		try {
			
			when(chefParkService.getHistoriqueDemandeVoitureByCurrentChef("chefPark"));
			
			this.mockMvc
			.perform(
					MockMvcRequestBuilders
					.post(url+"/getHistoriqueDemandeVoitureByCurrentChef")
					.param("userName","chefPark"))
					.andDo(print())
					.andExpect(status().isOk())
					.andExpect(content().contentType(MediaType.APPLICATION_JSON));
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}

}
