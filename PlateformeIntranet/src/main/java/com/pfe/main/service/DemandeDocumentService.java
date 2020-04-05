package com.pfe.main.service;

import java.util.List;

import com.pfe.main.entity.DemandeDocument;

public interface DemandeDocumentService {
public String CreateDemande(DemandeDocument demandeDocument);
public DemandeDocument getDemande(Long id);
public String updateDemande(DemandeDocument demandeDocument);
public List<DemandeDocument> getAllDemande();
public String deleteDemande(Long id);
}
