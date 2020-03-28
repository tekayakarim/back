package com.pfe.main.controller;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pfe.main.entity.Employe;
import com.pfe.main.service.EmployeService;

@RestController
@RequestMapping("/employe")
public class EmployeController {
	
@Autowired
private EmployeService employeService;

@GetMapping("/get")
public List<Employe> get(){
	return employeService.getEmploye();
}
@PostMapping("/add")
public String add(@RequestBody Employe emp) {
	return employeService.addEmploye(emp);
}




}
