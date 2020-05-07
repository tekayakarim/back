package com.pfe.main.controller;

import java.util.List;

import org.activiti.engine.task.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pfe.main.service.AgentDAAFService;

@RestController
@RequestMapping("/main/agentDAAF")
public class AgentDAAFController {
	
@Autowired
AgentDAAFService agentDAAFService;

@GetMapping("/getTask")
public List<Task> gettasks(String userName){
	return agentDAAFService.getTasks(userName);
}
@GetMapping("/complete")
public void completeTask(long taskId) {
   agentDAAFService.completeTask(taskId);
}
}
