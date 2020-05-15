package com.pfe.main.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pfe.main.entity.DemandeVoiture;
import com.pfe.main.entity.Employe;
import com.pfe.main.repository.DemandeVoitureRepository;
import com.pfe.main.repository.EmployeRepository;
import com.pfe.main.service.DemandeVoitureService;
@Service
public class DemandeVoitureServiceImpl implements DemandeVoitureService {
	
	@Autowired
	EmployeRepository employeRepository;
	@Autowired
	DemandeVoitureRepository demandeVoitureRepository;
	@Override
	public String CreateDemande(DemandeVoiture demandeVoiture) {
		try {
			Employe emp = employeRepository.findByNom(demandeVoiture.getEmp().getNom());
			if(emp!=null) {
				demandeVoiture.setEmp(emp);
				demandeVoiture.setStatut("new");
			if(demandeVoitureRepository.save(demandeVoiture)!=null)
				return "success";
			}//end if
			else {return "employe not found";}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return "Fail";
	
	}

	@Override
	public DemandeVoiture getDemande(long id) {
		return demandeVoitureRepository.findByid(id);
	}

	@Override
	public String updateDemande(DemandeVoiture demandeVoiture) {
		
		try {
			Employe emp = employeRepository.findByNom(demandeVoiture.getEmp().getNom());
			demandeVoiture.setEmp(emp);
			if(demandeVoitureRepository.findByid(demandeVoiture.getId())!=null) {
				if(demandeVoitureRepository.save(demandeVoiture)!=null)
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
	public List<DemandeVoiture> getAllDemande() {
		
		return demandeVoitureRepository.findAll();
	}

}
