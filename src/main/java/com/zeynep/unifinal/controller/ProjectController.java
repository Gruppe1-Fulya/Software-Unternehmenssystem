package com.zeynep.unifinal.controller;

import com.zeynep.unifinal.service.IDepartmentService;
import com.zeynep.unifinal.service.IEmployeeService;
import com.zeynep.unifinal.service.IProjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
@Controller
@RequestMapping("/project")
@RequiredArgsConstructor
public class ProjectController {
    private final IProjectService projectService;
    private final IDepartmentService departmentService;
        @GetMapping("/list")
        public ModelAndView findAllProject(){
            ModelAndView model = new ModelAndView();
            model.addObject("projects",projectService.getAllProjects());
            model.setViewName("tableproject");
            return model;
        }
    @GetMapping("/create")
    public ModelAndView createProjectModel(){
        ModelAndView model = new ModelAndView();
        model.addObject("departmentList",departmentService.getAllDepartment());

        model.setViewName("createproject");
        return model;
    }
    @PostMapping("/create")
    public ModelAndView createProject(String managedBy,String companyName,String projectName,Long departmentId,int employeeCount){
        System.out.println("managed By: "+managedBy+", companyName: "+companyName+" projectName: "+projectName+" departmentId: "+departmentId+" employeeCount: "+employeeCount);
            ModelAndView model = new ModelAndView();
        model.setViewName("redirect:/project/list");
        projectService.createProject(managedBy,companyName,projectName,departmentId,employeeCount);
        return model;
    }

    @GetMapping("/delete")
    public ModelAndView deleteProject(){
        ModelAndView model = new ModelAndView();
        model.addObject("projects",projectService.getAllProjects());
        model.setViewName("deleteproject");
        return model;
    }
    @PostMapping("/delete")
    public String deleteProject(Long projectId){
        projectService.deleteProject(projectId);

        return "redirect:/project/list";
    }
}
