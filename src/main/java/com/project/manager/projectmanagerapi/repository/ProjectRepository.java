package com.project.manager.projectmanagerapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.manager.projectmanagerapi.modal.Project;

public interface ProjectRepository extends JpaRepository<Project, Long> {

}
