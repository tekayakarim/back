package com.pfe.main.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pfe.main.entity.DemandeDocument;
import com.pfe.main.service.ChefDAAFService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/main/chefDAAF")
public class ChefDAAFController {
	
	@Autowired
	ChefDAAFService chefDAAFService;
	
	@GetMapping("/getAllAcceptedDemandeDocument")
	public List<DemandeDocument> getAllDemande(@RequestParam String userName){
		return chefDAAFService.getAllAcceptedDemande(userName);
	}
}