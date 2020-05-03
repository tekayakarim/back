package com.pfe.main.service;

import java.util.List;

import com.pfe.main.entity.DemandeDocument;

public interface ChefDAAFService {
	List<DemandeDocument> getAllAcceptedDemande(String userName);
}
