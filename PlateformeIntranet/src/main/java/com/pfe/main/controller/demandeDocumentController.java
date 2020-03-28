package com.pfe.main.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pfe.main.entity.DemandeDocument;
import com.pfe.main.service.DemandeDocumentService;


@RestController
@RequestMapping("/demandeDocument")
public class demandeDocumentController {

	@Autowired
	DemandeDocumentService demandeDocumentService;
	
	@PostMapping("/create")
	public String create(@RequestBody DemandeDocument demandeDocument) {
		return demandeDocumentService.CreateDemande(demandeDocument);
	}
	
}
