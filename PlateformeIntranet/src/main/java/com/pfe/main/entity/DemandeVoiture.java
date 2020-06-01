package com.pfe.main.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class DemandeVoiture {

@Id
@GeneratedValue
private long id;
private int nbPassergers;
private String description;
private String statut;
private String typeMission;
private String dateRecuperation;
private String dataDebut;
private String dataFin;
@OneToOne
private Employe emp;
public DemandeVoiture(int nbPassergers, String description, String statut, String typeMission, Employe emp) {
	super();
	this.nbPassergers = nbPassergers;
	this.description = description;
	this.statut = statut;
	this.typeMission = typeMission;
	this.emp = emp;
}
public DemandeVoiture() {
	super();

}
public String getDateRecuperation() {
	return dateRecuperation;
}
public void setDateRecuperation(String dateRecuperation) {
	this.dateRecuperation = dateRecuperation;
}
public long getId() {
	return id;
}
public void setId(long id) {
	this.id = id;
}
public int getNbPassergers() {
	return nbPassergers;
}
public void setNbPassergers(int nbPassergers) {
	this.nbPassergers = nbPassergers;
}
public String getDescription() {
	return description;
}
public void setDescription(String description) {
	this.description = description;
}
public String getStatut() {
	return statut;
}
public void setStatut(String statut) {
	this.statut = statut;
}
public String getTypeMission() {
	return typeMission;
}
public void setTypeMission(String typeMission) {
	this.typeMission = typeMission;
}
public Employe getEmp() {
	return emp;
}
public void setEmp(Employe emp) {
	this.emp = emp;
}

public String getDataDebut() {
	return dataDebut;
}
public void setDataDebut(String dataDebut) {
	this.dataDebut = dataDebut;
}
public String getDataFin() {
	return dataFin;
}
public void setDataFin(String dataFin) {
	this.dataFin = dataFin;
}
@Override
public boolean equals(Object obj) {
DemandeVoiture demande=(DemandeVoiture)obj;
	return super.equals(demande.getId());
}


}
