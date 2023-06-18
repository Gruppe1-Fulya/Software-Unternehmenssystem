package com.zeynep.unifinal.controller;

import com.zeynep.unifinal.service.IEmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/index")
@RequiredArgsConstructor
public class MainController {
    private final IEmployeeService employeeService;
    @GetMapping("")
    public ModelAndView index(){
        ModelAndView model = new ModelAndView();
        model.setViewName("index");
        return model;
    }

}
