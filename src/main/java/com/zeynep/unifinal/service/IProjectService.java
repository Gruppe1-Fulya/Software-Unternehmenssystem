package com.zeynep.unifinal.service;

import com.zeynep.unifinal.model.Project;

import java.util.List;

public interface IProjectService {
     Boolean createProject(String managedBy,String company,String projectName,Long departmentId,int employeeCount);
     List<Project> getAllProjects();

    void deleteProject(Long projectId);
}
