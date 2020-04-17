package com.pfe.main.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pfe.main.entity.ChefHierarchique;

public interface ChefHierarchiqueRepository extends JpaRepository<ChefHierarchique, Long> {
	ChefHierarchique findByCin(String cin);
}
