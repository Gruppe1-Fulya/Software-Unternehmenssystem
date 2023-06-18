package com.zeynep.unifinal.repository;

import com.zeynep.unifinal.model.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IDepartmentRepository extends JpaRepository<Department, Long> {
}
