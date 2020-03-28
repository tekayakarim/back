package com.pfe.main.serviceImpl;

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
		} catch (Exception e) {
			e.printStackTrace();
		}
		if(demandeDocumentRepository.save(demandeDocument)!=null)
			return "success";
		return "Fail";
	}

}
