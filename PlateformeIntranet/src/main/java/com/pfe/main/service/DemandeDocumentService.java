package com.pfe.main.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.pfe.main.entity.DemandeDocument;

public interface DemandeDocumentService {
public String CreateDemande(DemandeDocument demandeDocument);
public DemandeDocument getDemande(Long id);
public String updateDemande(DemandeDocument demandeDocument);
public List<DemandeDocument> getAllDemande();
public String deleteDemande(Long id);
public List<DemandeDocument> getAllDemandeByEmploye(String userName); 
}
