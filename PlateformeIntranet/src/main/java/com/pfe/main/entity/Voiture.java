package com.pfe.main.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Voiture {
@Id
private long id;
private String matricule;
private int nbChevaux;
private String couleur;
private double poidsAutrise;
public long getId() {
	return id;
}
public void setId(long id) {
	this.id = id;
}
public String getMatricule() {
	return matricule;
}
public void setMatricule(String matricule) {
	this.matricule = matricule;
}
public int getNbChevaux() {
	return nbChevaux;
}
public void setNbChevaux(int nbChevaux) {
	this.nbChevaux = nbChevaux;
}
public String getCouleur() {
	return couleur;
}
public void setCouleur(String couleur) {
	this.couleur = couleur;
}
public double getPoidsAutrise() {
	return poidsAutrise;
}
public void setPoidsAutrise(double poidsAutrise) {
	this.poidsAutrise = poidsAutrise;
}
public Voiture(String matricule, int nbChevaux, String couleur, double poidsAutrise) {
	super();
	this.matricule = matricule;
	this.nbChevaux = nbChevaux;
	this.couleur = couleur;
	this.poidsAutrise = poidsAutrise;
}
public Voiture() {
	super();
}


}
