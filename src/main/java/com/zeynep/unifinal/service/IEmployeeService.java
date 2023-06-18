package com.zeynep.unifinal.service;


import com.zeynep.unifinal.model.Employee;

import java.util.List;

public interface IEmployeeService {
    public String registerEmployee(String name, String surname,String email,String password,
                                   String phone,Long salary,String address,Long departmentId);


    public List<Employee> getAllEmployee();
    public Employee getEmployeeById(Long id);
    void updateEmployee(Employee employee);



    }
