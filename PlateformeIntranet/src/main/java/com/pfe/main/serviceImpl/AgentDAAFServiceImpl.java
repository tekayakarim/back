package com.pfe.main.serviceImpl;

import java.util.List;

import org.activiti.engine.TaskService;
import org.activiti.engine.task.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pfe.main.service.AgentDAAFService;
@Service
public class AgentDAAFServiceImpl implements AgentDAAFService {
	
	@Autowired
	private TaskService taskService;
	
	@Override
	public List<Task> getTasks(String userName) {
		return taskService.createTaskQuery().taskAssignee(userName).list();
	}

	@Override
	public void completeTask(long taskId) {
		taskService.complete(String.valueOf(taskId));

	}

}
