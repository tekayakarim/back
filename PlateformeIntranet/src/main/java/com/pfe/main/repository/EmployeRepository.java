package com.pfe.main.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pfe.main.entity.Employe;



public interface EmployeRepository extends JpaRepository<Employe,Long> {
Employe findByCin(String cin);
Employe findByNom(String nom);
}
