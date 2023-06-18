package com.zeynep.unifinal.service;

import com.zeynep.unifinal.model.ProjectEmployee;

import java.util.List;

public interface IProjectEmployeeService {

    public void addEmployeeToProject(Long employeeId, Long projectId) ;

    public List<ProjectEmployee> getProjectEmployeeList(Long projectId) ;

}
