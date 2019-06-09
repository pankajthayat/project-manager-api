package com.project.manager.projectmanagerapi.controller;

import com.project.manager.projectmanagerapi.exception.ProjectNotFoundException;
import com.project.manager.projectmanagerapi.modal.Project;
import com.project.manager.projectmanagerapi.modal.User;
import com.project.manager.projectmanagerapi.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = {"*"})
@RequestMapping("project")
public class ProjectController {

    @Autowired
    ProjectRepository projectRepository;
    @PostMapping("/add")
    public ResponseEntity<Project> addProject(@Valid @RequestBody Project project) throws Exception{
        return ResponseEntity.status(HttpStatus.CREATED).body(projectRepository.save(project));

    }

    @PutMapping("/update")
    public ResponseEntity<Project> updateProject(@Valid @RequestBody Project project) throws Exception{
        return ResponseEntity.status(HttpStatus.CREATED).body(projectRepository.save(project));

    }

    @DeleteMapping("/delete/{id}")
    public void deleteProject(@PathVariable  Long id) {
        if(!projectRepository.findById(id).isPresent())
            throw new ProjectNotFoundException("Project not found with id : "+id);
            projectRepository.deleteById(id);
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<Project>> getAllProjects(){
        return ResponseEntity.status(HttpStatus.FOUND).body(projectRepository.findAll());
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Optional<Project>> getProject(@PathVariable Long id){
        if(!projectRepository.findById(id).isPresent())
            throw new ProjectNotFoundException("Project not found with id : "+id);
        return ResponseEntity.status(HttpStatus.FOUND).body(projectRepository.findById(id));
    }

}
