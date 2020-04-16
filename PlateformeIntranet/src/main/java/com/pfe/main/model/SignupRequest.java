package com.pfe.main.model;

import javax.validation.constraints.*;
 
public class SignupRequest {
    @NotBlank
    @Size(min = 3, max = 20)
    private String userName;
     
    private String role; 
    private String nom;
    private String prenom;
   private String chefHiercharchiqueCin;
   
	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	@NotBlank
    @Size(min = 6, max = 40)
    private String password;
    @NotBlank
    @Size(max = 8)
  private String cin;
    
    public String getCin() {
		return cin;
	}

	public void setCin(String cin) {
		this.cin = cin;
	}

	public String getUserName() {
        return userName;
    }
 
    public void setUserName(String username) {
        this.userName = username;
    }
 
 
    public String getPassword() {
        return password;
    }
 
    public void setPassword(String password) {
        this.password = password;
    }

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getChefHiercharchiqueCin() {
		return chefHiercharchiqueCin;
	}

	public void setChefHiercharchiqueCin(String chefHiercharchiqueCin) {
		this.chefHiercharchiqueCin = chefHiercharchiqueCin;
	}
    

}
