package com.pfe.main.entity;

import java.util.List;



import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity
public class Employe extends JwtUser{

	
	@OneToMany
	private List<DemandeVoiture> listDemandeVoiture;


	
}
