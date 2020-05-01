package com.pfe.main.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pfe.main.entity.DemandeDocument;
import com.pfe.main.service.ChefHierarchiqueService;

@RestController
@RequestMapping("/main/chefHierarchique")
public class ChefHierarchiqueController {
@Autowired
ChefHierarchiqueService chefHierarchiqueService;
@GetMapping("/getAllDemandeDocument")
public List<DemandeDocument> getAllDemande(@RequestParam String userName){
	return chefHierarchiqueService.getAllNewDemande(userName);
}
}
