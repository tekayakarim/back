package com.pfe.main.entity;

import java.util.List;




import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity
public class ChefHierarchique extends JwtUser{



	@OneToMany
	private List<DemandeVoiture> listDemandeVoiture;
	
	@OneToMany 
	private List<DemandeDocument> listDemandeDocument;

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
