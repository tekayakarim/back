package com.pfe.main.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.pfe.main.entity.DemandeDocument;

public interface ChefHierarchiqueService {
List<DemandeDocument> getAllNewDemande(String userName);
String updateDemandeDocument(long id,String statut);
}
