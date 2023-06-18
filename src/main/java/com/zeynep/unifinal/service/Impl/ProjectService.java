package com.zeynep.unifinal.service.Impl;

import com.zeynep.unifinal.model.Employee;
import com.zeynep.unifinal.model.Project;
import com.zeynep.unifinal.model.ProjectEmployee;
import com.zeynep.unifinal.repository.IProjectRepository;
import com.zeynep.unifinal.service.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProjectService implements IProjectService {
    private final IProjectRepository projectRepository;
    private final IDepartmentService departmentService;
    private final IProjectEmployeeService projectEmployeeService;
    private final IEmployeeService employeeService;

    public Boolean createProject(String managedBy, String companyName, String projectName, Long departmentId, int employeeCount) {
        if (departmentService.getAllDepartment().stream().filter(x -> x.getId() == departmentId).count() == 0) {
            throw new RuntimeException("department not found");
        }
        List<Employee> employees = employeeService.getAllEmployee().stream().filter(x -> x.getDepartmentId() == departmentId).collect(Collectors.toList());
        Project project = projectRepository.save(Project.builder()
                .managedBy(managedBy)
                .company(companyName)
                .projectName(projectName)
                .departmentId(departmentId)
                .employeeCount(employeeCount)
                .startDate(LocalDateTime.now().toString())
                .build());
        for (Employee employee : employees.stream().filter(x -> x.getIsActive() == false).collect(Collectors.toList())) {
            projectEmployeeService.addEmployeeToProject(employee.getId(), project.getId());
        }
        return true;
    }


    public List<Project> getAllProjects() {
        return projectRepository.findAll();
    }

    @Override
    public void deleteProject(Long projectId) {
        Optional<Project> project = projectRepository.findById(projectId);
        if (project.isEmpty()) {
            throw new RuntimeException("project not found");
        }
        List<ProjectEmployee> projectEmployees = projectEmployeeService.getProjectEmployeeList(projectId);
        for (ProjectEmployee projectEmployee : projectEmployees) {
            Employee employee = employeeService.getEmployeeById(projectEmployee.getEmployeeId());
            employee.setIsActive(false);
            employeeService.updateEmployee(employee);
        }
        project.get().setEndDate(LocalDateTime.now().toString());
        projectRepository.save(project.get());
    }

}
