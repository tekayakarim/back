package com.pfe.main.entity;

import java.util.List;




import javax.persistence.Entity;
import javax.persistence.OneToMany;
@Entity
public class ChefPark extends JwtUser{



	@OneToMany
	private List<DemandeVoiture> listDemandeVoiture;
	
	@OneToMany
	private List<Voiture> listVoiture;
	
	
}
