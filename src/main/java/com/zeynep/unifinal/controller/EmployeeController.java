package com.zeynep.unifinal.controller;

import com.zeynep.unifinal.service.IEmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@RequiredArgsConstructor
@RequestMapping("/employee")
@Controller
@CrossOrigin("*")
public class EmployeeController {
    private final IEmployeeService employeeService;

    @GetMapping("list")
    public ModelAndView employeelist(){
        ModelAndView model = new ModelAndView();
        model.addObject("employees",employeeService.getAllEmployee());
        model.setViewName("tableemployee");
        return model;
    }
    @GetMapping("/register")
    public ModelAndView modelRegister(){
        ModelAndView model = new ModelAndView();
        model.setViewName("register");
        return model;
    }

    @PostMapping("/register")
    public String registerEmployee(String name, String surname,String email,String password,
                                         String phone,Long salary,String address, Long departmentId){


        employeeService.registerEmployee(name,surname,email,password,phone,salary,address,departmentId);

        return "redirect:/index";
    }
}
