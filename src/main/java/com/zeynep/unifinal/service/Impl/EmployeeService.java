package com.zeynep.unifinal.service.Impl;
import com.zeynep.unifinal.model.Employee;
import com.zeynep.unifinal.repository.IEmployeeRepository;
import com.zeynep.unifinal.service.IDepartmentService;
import com.zeynep.unifinal.service.IEmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor

public class EmployeeService implements IEmployeeService {
    private final IEmployeeRepository employeeRepository;
    private final IDepartmentService departmentService;

    public String registerEmployee(String name, String surname,String email,String password,
                                   String phone,Long salary,String address,Long departmentId) {

        if (email.isEmpty()|| password==null || name.isEmpty()||surname.isEmpty()||phone.isEmpty()||address.isEmpty()||salary==null){
            throw new RuntimeException("email or password cannot be empty");
        }
        if (departmentService.getAllDepartment().stream().filter(x->x.getId() == departmentId).count()==0){
            throw new RuntimeException("department not found");
        }
        Employee employee= Employee.builder()
                .name(name)
                .surname(surname)
                .email(email)
                .password(password)
                .phone(phone)
                .salary(salary)
                .address(address)
                .departmentId(departmentId)
                .isActive(false)
                .build();
        employeeRepository.save(employee);
        return "registration successful";
    }
    public List<Employee> getAllEmployee(){
        return employeeRepository.findAll();
    }
    public Employee getEmployeeById(Long id){
        return employeeRepository.findById(id).get();
    }

    @Override
    public void updateEmployee(Employee employee) {
        employeeRepository.save(employee);
    }


}
