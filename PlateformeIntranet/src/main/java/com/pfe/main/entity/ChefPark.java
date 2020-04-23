package com.pfe.main.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
@Entity
public class ChefPark extends JwtUser{



	@OneToMany(cascade = CascadeType.ALL)
	private List<DemandeVoiture> listDemandeVoiture;
	
	@OneToMany(cascade = CascadeType.ALL)
	private List<Voiture> listVoiture;
	
	
}
