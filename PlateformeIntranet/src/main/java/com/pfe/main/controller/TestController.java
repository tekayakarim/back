package com.pfe.main.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/main")
public class TestController {
	@GetMapping("/all")
	public String allAccess() {
		return "Public Content.";
	}
	
	@GetMapping("/user")
/*	@PreAuthorize("hasRole('EMPLOYE') or hasRole('CHEFPARK') or hasRole('ADMIN')"
			+ "or hasRole('CHEFHIERARCHIQUE') or hasRole('AGENTDAAF')")*/
	public String userAccess() {
		return "User Content.";
	}
 
	@GetMapping("/chef")
	@PreAuthorize("hasRole('CHEFPARK')")
	public String moderatorAccess() {
		return "Chef park Board.";
	}

	@GetMapping("/admin")
	@PreAuthorize("hasRole('ADMIN')")
	public String adminAccess() {
		return "Admin Board.";
	}
}
