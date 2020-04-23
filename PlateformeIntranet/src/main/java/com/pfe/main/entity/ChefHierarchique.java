package com.pfe.main.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity
public class ChefHierarchique extends JwtUser{



	@OneToMany(cascade = CascadeType.ALL)
	private List<DemandeVoiture> listDemandeVoiture;
	
	@OneToMany(cascade = CascadeType.ALL) 
	private List<DemandeDocument> listDemandeDocument;
	
	@OneToMany(cascade = CascadeType.ALL)
	private List<Employe> listEmploye;
	

	public List<Employe> getListEmploye() {
		return listEmploye;
	}

	public void setListEmploye(List<Employe> listEmploye) {
		this.listEmploye = listEmploye;
	}

	public List<DemandeVoiture> getListDemandeVoiture() {
		return listDemandeVoiture;
	}

	public void setListDemandeVoiture(List<DemandeVoiture> listDemandeVoiture) {
		this.listDemandeVoiture = listDemandeVoiture;
	}

	public List<DemandeDocument> getListDemandeDocument() {
		return listDemandeDocument;
	}

	public void setListDemandeDocument(List<DemandeDocument> listDemandeDocument) {
		this.listDemandeDocument = listDemandeDocument;
	}
	
	
	

}
