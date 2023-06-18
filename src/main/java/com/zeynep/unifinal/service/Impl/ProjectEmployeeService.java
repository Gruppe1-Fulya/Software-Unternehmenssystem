package com.zeynep.unifinal.service.Impl;

import com.zeynep.unifinal.model.Employee;
import com.zeynep.unifinal.model.ProjectEmployee;
import com.zeynep.unifinal.repository.IProjectEmployeeRepository;
import com.zeynep.unifinal.service.IEmployeeService;
import com.zeynep.unifinal.service.IProjectEmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProjectEmployeeService implements IProjectEmployeeService {

    private final IProjectEmployeeRepository projectEmployeeRepository;
    private final IEmployeeService employeeService;

    public void addEmployeeToProject(Long employeeId, Long projectId) {
        Employee employee=employeeService.getEmployeeById(employeeId);
        employee.setIsActive(true);
        projectEmployeeRepository.save(ProjectEmployee.builder()
                        .employeeId(employeeId)
                .projectId(projectId)
                .build());
    }


    public List<ProjectEmployee> getProjectEmployeeList(Long projectId) {
        return projectEmployeeRepository.findByProjectId(projectId);
    }
}
