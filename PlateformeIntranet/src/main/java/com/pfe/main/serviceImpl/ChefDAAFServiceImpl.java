package com.pfe.main.serviceImpl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.task.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pfe.main.entity.AgentDAAF;
import com.pfe.main.entity.ChefDAAF;
import com.pfe.main.entity.ChefHierarchique;
import com.pfe.main.entity.DemandeDocument;
import com.pfe.main.repository.AgentDAAFRepository;
import com.pfe.main.repository.ChefDAAFRepository;
import com.pfe.main.repository.DemandeDocumentRepository;
import com.pfe.main.service.ChefDAAFService;
@Service
public class ChefDAAFServiceImpl implements ChefDAAFService {
	
	@Autowired
	ChefDAAFRepository chefDAAFRepository;
	
	@Autowired
	AgentDAAFRepository agentDAAFRepository;
	
	@Autowired
	private RuntimeService runtimeService;
	
	@Autowired
	DemandeDocumentRepository demandeDocumentRepository;
	
	@Autowired
	private TaskService taskService;

	@Autowired
	private RepositoryService repositoryService;
	
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
	@Override
	public String ConfierDemande(long idDemande,String userName) {
		AgentDAAF agent=agentDAAFRepository.findByUserName(userName);
		DemandeDocument demande=demandeDocumentRepository.findByid(idDemande);
		System.out.println(agent);
		if(agent.getDemandeDocument()!=null)
			return "cet agent travaille deja sur une demande";
		else if(demande==null) {
			return "demande introuvable";
		}
		else if(!demande.getStatut().equals("accepted")) {
			return "demande n'est pas accepter";
		}
		else
		{
			//set dem to agent
			agent.setDemandeDocument(demande);
			agentDAAFRepository.flush();
			//begin the process 
			Map<String, Object> variables = new HashMap<>();
			variables.put("agent", agent);

			runtimeService.startProcessInstanceByKey("demandeDocumentProcess", variables);

			return processInformation();	
		}
	}
	@Override
	public List<AgentDAAF> listerAgentDemandeNull(String userName) {
		try {
			ChefDAAF chef=chefDAAFRepository.findByUserName(userName);
			//recuperer les agents de chef
			List<AgentDAAF> lst=chef.getListAgent();
			//liste vide d'agent
			List<AgentDAAF> lstVide=new ArrayList<AgentDAAF>();
			for(AgentDAAF agent:lst) {
				if(agent.getDemandeDocument()==null)
					lstVide.add(agent);
			}//end for
			return lstVide;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	

	// fetching process and task information
		public String processInformation() {
	
			List<Task> taskList = taskService.createTaskQuery().orderByTaskCreateTime().asc().list();
	
			StringBuilder processAndTaskInfo = new StringBuilder();
			
			processAndTaskInfo.append("Number of process definition available: "
					+ repositoryService.createProcessDefinitionQuery().count() + " | Task Details= ");
	
			taskList.forEach(task -> {
	
				processAndTaskInfo.append("\n"+"ID: " + task.getId() + ", Name: " + task.getName() + ", Assignee: "
						+ task.getAssignee() );
			});
	
			return processAndTaskInfo.toString();
		}
	


}
