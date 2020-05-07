package com.pfe.main.service;

import java.util.List;

import org.activiti.engine.task.Task;

public interface AgentDAAFService {
List<Task> getTasks(String userName);
void completeTask(long taskId);
}
