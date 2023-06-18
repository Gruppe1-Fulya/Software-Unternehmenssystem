package com.zeynep.unifinal.service.Impl;

import com.zeynep.unifinal.model.Department;
import com.zeynep.unifinal.repository.IDepartmentRepository;
import com.zeynep.unifinal.service.IDepartmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DepartmentService implements IDepartmentService {
    private final IDepartmentRepository departmentRepository;

    public Boolean createDepartment(String departmentName) {
        if (departmentName==null || departmentName.isEmpty()) return false;
        departmentRepository.save(Department.builder()
                        .departmentName(departmentName)
                .build());
        return true;
    }
    public List<Department> getAllDepartment() {
        return departmentRepository.findAll();
    }
}
