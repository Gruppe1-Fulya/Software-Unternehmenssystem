package com.zeynep.unifinal.controller;

import com.zeynep.unifinal.service.IDepartmentService;
import com.zeynep.unifinal.service.Impl.DepartmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequiredArgsConstructor
@RequestMapping("/department")
public class DepartmentController {
    private final IDepartmentService departmentService;
    @GetMapping("/create")
    public ModelAndView model (){
        ModelAndView model = new ModelAndView();
        model.setViewName("createdepartment");
        return model;
    }

    @PostMapping("/create")
    public ModelAndView createDepartment (String departmentName){
        Boolean state=departmentService.createDepartment(departmentName);
        if (state)
            return new ModelAndView("redirect:/department/list");
        else
            return new ModelAndView("redirect:/department/create");

    }
    @GetMapping("/list")
    public ModelAndView departmentList (){
        ModelAndView model = new ModelAndView();
        model.setViewName("tabledepartment");
        model.addObject("departmentList",departmentService.getAllDepartment());
        return model;
    }
}
