package com.pfe.main.entity;

import java.util.List;



import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
public class Employe extends JwtUser{

	@OneToOne
	private ChefHierarchique chefHierarchique;
	@OneToMany
	private List<DemandeVoiture> listDemandeVoiture;
	public ChefHierarchique getChefHierarchique() {
		return chefHierarchique;
	}
	public void setChefHierarchique(ChefHierarchique chefHierarchique) {
		this.chefHierarchique = chefHierarchique;
	}
	public List<DemandeVoiture> getListDemandeVoiture() {
		return listDemandeVoiture;
	}
	public void setListDemandeVoiture(List<DemandeVoiture> listDemandeVoiture) {
		this.listDemandeVoiture = listDemandeVoiture;
	}
	public Employe(ChefHierarchique chefHierarchique) {
		super();
		this.chefHierarchique = chefHierarchique;
	}


	
}
