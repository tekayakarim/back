package com.pfe.main.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pfe.main.entity.Employe;
import com.pfe.main.repository.EmployeRepository;
import com.pfe.main.service.EmployeService;

@Service
public class EmployeServiceImpl implements EmployeService {

	@Autowired
	private EmployeRepository employeRepository;

	@Override
	public List<Employe> getEmploye() {
		return employeRepository.findAll();
	}
	@Override
	public String addEmploye(Employe emp) {
		
		if(verifEmployeByCin(emp)) 
			return "found";

		if(employeRepository.save(emp)!=null)
		{
			return "added";
		}
		return "fail";
	}
	
	@Override
	public boolean verifEmployeByCin(Employe emp) {
	   List<Employe> list=new ArrayList<Employe>();
	   boolean test=false;
	   try {
		list.addAll(getEmploye());
		for(Employe e:list)
		{
			if(e.getCin().equals(emp.getCin()))
			{
				test=true;
			
			}
		}
	} catch (Exception e) {
		e.printStackTrace();
	}
		return test;
	}


}
