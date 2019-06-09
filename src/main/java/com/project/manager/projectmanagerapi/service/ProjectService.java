package com.project.manager.projectmanagerapi.service;

import com.project.manager.projectmanagerapi.modal.Project;
import com.project.manager.projectmanagerapi.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class ProjectService {

    @Autowired
    ProjectRepository projectRepository;
    public Project updateProject(){
        return new Project();
    }
}
