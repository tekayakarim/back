package com.pfe.main.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pfe.main.entity.JwtUser;
import com.pfe.main.repository.ChefHierarchiqueRepository;
import com.pfe.main.service.EmployeService;

@RestController
@RequestMapping("/main/user")
public class UserController {
	
@Autowired
EmployeService employeService;


@GetMapping("/getCurrentUserEmploye")
public JwtUser getUserEmploye(@RequestParam String userName) {
	return employeService.getEmploye(userName);
}
}