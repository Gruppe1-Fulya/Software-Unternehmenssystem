package com.zeynep.unifinal.repository;

import com.zeynep.unifinal.model.ProjectEmployee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IProjectEmployeeRepository extends JpaRepository<ProjectEmployee,Long> {
    List<ProjectEmployee> findByProjectId(Long projectId);
}
