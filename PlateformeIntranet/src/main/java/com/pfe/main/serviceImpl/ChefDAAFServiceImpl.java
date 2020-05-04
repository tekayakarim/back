package com.pfe.main.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pfe.main.entity.ChefDAAF;
import com.pfe.main.entity.ChefHierarchique;
import com.pfe.main.entity.DemandeDocument;
import com.pfe.main.repository.ChefDAAFRepository;
import com.pfe.main.repository.DemandeDocumentRepository;
import com.pfe.main.service.ChefDAAFService;
@Service
public class ChefDAAFServiceImpl implements ChefDAAFService {
	
	@Autowired
	ChefDAAFRepository chefDAAFRepository;
	
	@Autowired
	DemandeDocumentRepository demandeDocumentRepository;
	@Override
	public List<DemandeDocument> getAllAcceptedDemande(String userName) {
		try {
			//current user chef
			ChefDAAF user=chefDAAFRepository.findByUserName(userName);
			System.out.println(user);
			user.setListDemandeDocument(null);
			chefDAAFRepository.flush();
			//all demandes
			List<DemandeDocument> lstAllDemande=demandeDocumentRepository.findAll();
			//liste vide de document
			List<DemandeDocument> lstDemandesChef=new ArrayList<DemandeDocument>();
			//recuperer les demandes accepter par les chefs hierarchiques
			for(DemandeDocument dem:lstAllDemande)
			{
				if(!dem.getStatut().equals("new")
				&& !dem.getStatut().equals("denied"))
				{
					lstDemandesChef.add(dem);	
				}//end if
			}//end for
			user.setListDemandeDocument(lstDemandesChef);
			chefDAAFRepository.flush();
			return user.getListDemandeDocument();
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		return null;
	}

}
