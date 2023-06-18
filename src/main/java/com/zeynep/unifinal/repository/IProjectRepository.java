package com.zeynep.unifinal.repository;

import com.zeynep.unifinal.model.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IProjectRepository  extends JpaRepository<Project,Long> {
}
