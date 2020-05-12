package com.pfe.main.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pfe.main.entity.ChefHierarchique;
import com.pfe.main.entity.DemandeDocument;
import com.pfe.main.repository.ChefHierarchiqueRepository;
import com.pfe.main.repository.DemandeDocumentRepository;
import com.pfe.main.service.ChefHierarchiqueService;
@Service
public class ChefHierarchiqueServiceImpl implements ChefHierarchiqueService {
	@Autowired
	ChefHierarchiqueRepository chefHierarchiqueRepository;
	@Autowired
	DemandeDocumentRepository demandeDocumentRepository;
	@Override
	public List<DemandeDocument> getAllNewDemande(String userName) {
		try {
			//current user chef
			ChefHierarchique user=chefHierarchiqueRepository.findByUserName(userName);
			user.setListDemandeDocument(null);
			chefHierarchiqueRepository.flush();
			//all demandes
			List<DemandeDocument> lstAllDemande=demandeDocumentRepository.findAll();
			//liste vide de document
			List<DemandeDocument> lstDemandesChef=new ArrayList<DemandeDocument>();
			//recuperer les demandes des employes de ce chef <user>
			for(DemandeDocument dem:lstAllDemande)
			{
				if(dem.getEmp().getChefHierarchiqueCin().equals(user.getCin()) 
						&& !dem.getStatut().equals("accepted")
						&& !dem.getStatut().equals("denied"))
				{
					lstDemandesChef.add(dem);	
				}//end if
			}//end for
			user.setListDemandeDocument(lstDemandesChef);
			chefHierarchiqueRepository.flush();
			return user.getListDemandeDocument();
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		return null;
	}
	@Override
	public String updateDemandeDocument(long id,String statut) {
		try {
			DemandeDocument dem=demandeDocumentRepository.findByid(id);
			dem.setStatut(statut);
			demandeDocumentRepository.flush();
			return "updated";
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return "fail";
	}
	@Override
	public List<ChefHierarchique> listerAllChefHie() {
		
		return chefHierarchiqueRepository.findAll();
	}

}
