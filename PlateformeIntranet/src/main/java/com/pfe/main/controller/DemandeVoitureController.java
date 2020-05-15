package com.pfe.main.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pfe.main.entity.DemandeVoiture;
import com.pfe.main.service.DemandeVoitureService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/main/demandeVoiture")
public class DemandeVoitureController {
	
	@Autowired
	DemandeVoitureService demandeVoitureService;
	@PostMapping("/add")  
	public String create(@RequestBody DemandeVoiture demandeVoiture) {
		return demandeVoitureService.CreateDemande(demandeVoiture);
	}
	@GetMapping("/get")
	public DemandeVoiture get(@RequestParam Long id) {
	return 	demandeVoitureService.getDemande(id);
	}
	@PutMapping("/update")
	public String update(@RequestBody DemandeVoiture demandeVoiture) {
		return demandeVoitureService.updateDemande(demandeVoiture);
	}
	@GetMapping("/getAll")
	public List<DemandeVoiture> getAll(){
		return demandeVoitureService.getAllDemande();
	}
}
