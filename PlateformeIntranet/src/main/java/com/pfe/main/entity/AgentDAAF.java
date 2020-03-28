package com.pfe.main.entity;

import javax.persistence.Entity;




import javax.persistence.OneToOne;


@Entity
public class AgentDAAF extends JwtUser{


	@OneToOne
	private DemandeDocument demandeDocument;
	

}
