package com.pfe.main.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pfe.main.entity.AgentDAAF;
import com.pfe.main.repository.AgentDAAFRepository;
import com.pfe.main.service.ActivitiService;
import com.pfe.main.service.AgentDAAFService;
@Service
public class AgentDAAFServiceImpl implements AgentDAAFService {
	
	@Autowired
	ActivitiService activitiService;
	
	@Autowired
	AgentDAAFRepository agentDAAFRepository;
	@Override
	public String getDemandeToDo(String userName) {
		return activitiService.processInformation();

	}

	@Override
	public String DemandeDone(String userName,String id) {
		activitiService.completeTask(id);
		try {
			AgentDAAF agent=agentDAAFRepository.findByUserName(userName);
			agent.setDemandeDocument(null);
			agentDAAFRepository.flush();
			return "Demande done";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "fail to complete demande";
	}

	@Override
	public AgentDAAF getAgent(long id) {
		
		return agentDAAFRepository.findByid(id);
	}
	

}
