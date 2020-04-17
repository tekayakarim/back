package com.pfe.main.entity;

import java.util.List;



import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
public class Employe extends JwtUser{

	private String chefHierarchiqueCin;
	@OneToMany
	private List<DemandeVoiture> listDemandeVoiture;

	public String getChefHierarchiqueCin() {
		return chefHierarchiqueCin;
	}
	public void setChefHierarchiqueCin(String chefHierarchiqueCin) {
		this.chefHierarchiqueCin = chefHierarchiqueCin;
	}
	public List<DemandeVoiture> getListDemandeVoiture() {
		return listDemandeVoiture;
	}
	public void setListDemandeVoiture(List<DemandeVoiture> listDemandeVoiture) {
		this.listDemandeVoiture = listDemandeVoiture;
	}
	public Employe(String chefHierarchiqueCin) {
		super();
		this.chefHierarchiqueCin=chefHierarchiqueCin;
	}
	public Employe() {
		super();
		
	}


	
}
