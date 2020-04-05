package com.pfe.main.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;



import org.springframework.stereotype.Service;

import com.pfe.main.entity.DemandeDocument;
import com.pfe.main.entity.Employe;
import com.pfe.main.repository.DemandeDocumentRepository;
import com.pfe.main.repository.EmployeRepository;
import com.pfe.main.service.DemandeDocumentService;

@Service
public class DemandeDocumentServiceImpl implements DemandeDocumentService {

	@Autowired
	DemandeDocumentRepository demandeDocumentRepository;
	@Autowired
	EmployeRepository employeRepository;
	@Override
	public String CreateDemande(DemandeDocument demandeDocument) {
		
		try {
			Employe emp = employeRepository.findByNom(demandeDocument.getEmp().getNom());
			demandeDocument.setEmp(emp);
			if(demandeDocumentRepository.save(demandeDocument)!=null)
				return "success";
		} catch (Exception e) {
			e.printStackTrace();
		}

		return "Fail";
	}
	@Override
	public DemandeDocument getDemande(Long id) {
	
		return demandeDocumentRepository.findByid(id);
	}
	@Override
	public String updateDemande(DemandeDocument demandeDocument) {
	
		
		try {
			Employe emp = employeRepository.findByNom(demandeDocument.getEmp().getNom());
			demandeDocument.setEmp(emp);
			if(demandeDocumentRepository.findByid(demandeDocument.getId())!=null) {
				if(demandeDocumentRepository.save(demandeDocument)!=null)
				return "success";
			}
			else
				return "demande not found ";
		} catch (Exception e) {
			e.printStackTrace();
		}

		return "Fail";
	}
	@Override
	public List<DemandeDocument> getAllDemande() {
	
		return demandeDocumentRepository.findAll();
	}
	@Override  
	public String deleteDemande(Long id) {
		try {
			demandeDocumentRepository.deleteById(id);
			return "success";
		} catch (IllegalArgumentException e) {
			System.out.println("demande not found");
			e.printStackTrace();
		}
		return "fail";
	} 
	@Override
	public List<DemandeDocument> getAllDemandeByEmploye(String userName) {
		//liste vide de documents
		ArrayList<DemandeDocument> lstDocument=new ArrayList<DemandeDocument>();
		try {
			Employe emp=employeRepository.findByUserName(userName);
			for(DemandeDocument dem:this.getAllDemande()) {
				if(dem.getEmp().equals(emp))
					lstDocument.add(dem);
			}//end for
		} //end try
		catch (Exception e) {e.printStackTrace();}
		
		return lstDocument;
	}
	

}
