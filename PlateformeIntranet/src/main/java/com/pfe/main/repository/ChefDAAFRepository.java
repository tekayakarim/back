package com.pfe.main.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pfe.main.entity.ChefDAAF;
@Repository
public interface ChefDAAFRepository extends JpaRepository<ChefDAAF, Long> {

}