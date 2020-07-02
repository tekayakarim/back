package com.pfe.main.entity;

import javax.persistence.Entity;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
public class Employe extends JwtUser{

	private String chefHierarchiqueCin;


	public String getChefHierarchiqueCin() {
		return chefHierarchiqueCin;
	}
	public void setChefHierarchiqueCin(String chefHierarchiqueCin) {
		this.chefHierarchiqueCin = chefHierarchiqueCin;
	}

	public Employe(String chefHierarchiqueCin) {
		super();
		this.chefHierarchiqueCin=chefHierarchiqueCin;
	}
	public Employe() {
		super();
		
	}
	public Employe(@NotBlank @Size(max = 20) String userName,@NotBlank String password) {
		super(userName,password);
		
	}
	




	
}
