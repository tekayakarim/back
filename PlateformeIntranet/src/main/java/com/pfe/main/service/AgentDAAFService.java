package com.pfe.main.service;

import java.util.List;

import org.activiti.engine.task.Task;

public interface AgentDAAFService {
String getDemandeToDo(String userName);
String DemandeDone(String userName,String id);
}
