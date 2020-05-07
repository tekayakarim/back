package com.pfe.main.service;

import java.util.List;

import com.pfe.main.entity.AgentDAAF;
import com.pfe.main.entity.DemandeDocument;

public interface ChefDAAFService {
	List<DemandeDocument> getAllAcceptedDemande(String userName);
	String ConfierDemande(long idDemande,String userName);
	List<AgentDAAF> listerAgentDemandeNull(String userName);
}
