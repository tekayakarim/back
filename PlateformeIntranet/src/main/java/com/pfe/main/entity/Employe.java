package com.pfe.main.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;

@Entity
public class Employe extends JwtUser{

	private String chefHierarchiqueCin;
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(	name = "Employe_List_Demande_voiture", 
				joinColumns = @JoinColumn(name = "Employe_id"), 
				inverseJoinColumns = @JoinColumn(name = "demande_voiture_id"))
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
