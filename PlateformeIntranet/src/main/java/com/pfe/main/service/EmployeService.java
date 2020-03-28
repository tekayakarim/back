package com.pfe.main.service;

import java.util.List;

import com.pfe.main.entity.Employe;



public interface EmployeService {
public List<Employe> getEmploye();
public String addEmploye(Employe emp);
public boolean verifEmployeByCin(Employe emp);
}
