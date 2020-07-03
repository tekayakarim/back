package com.pfe.main;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.pfe.main.controller.*;

@SpringBootTest
public class AssertControllerNotNull {
	@Autowired
	private AuthController authController;
	
	@Autowired
	private ChefHierarchiqueController chefHierarchiqueController;
	
	@Autowired
	private DemandeDocumentController demandeDocumentController;
	
	@Autowired
	private TestController testController;
	
	@Autowired
	private UserController userController;
	
	@Autowired
	private AgentDAAFController agentDAAFController;
	
	@Autowired
	private ChefDAAFController chefDAAFController;
	
	@Autowired
	private ChefParkController chefParkController;
	
	@Autowired
	private DemandeVoitureController demandeVoitureController;
	
	@Test
	public void contexLoads() throws Exception {
		//authController
		assertThat(authController).isNotNull();
		
		//chefHierarchiqueController
		assertThat(chefHierarchiqueController).isNotNull();
		
		//demandeDocumentController
		assertThat(demandeDocumentController).isNotNull();
		
		//testController
		assertThat(testController).isNotNull();
		
		//userController
		assertThat(userController).isNotNull();
		
		//agentDAAFController
		assertThat(agentDAAFController).isNotNull();
		
		//chefDAAFController
		assertThat(chefDAAFController).isNotNull();
		
		//chefParkController
		assertThat(chefParkController).isNotNull();
		
		//demandeVoitureController
		assertThat(demandeVoitureController).isNotNull();
	}

}
