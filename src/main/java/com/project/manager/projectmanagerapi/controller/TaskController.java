package com.project.manager.projectmanagerapi.controller;

import com.project.manager.projectmanagerapi.exception.ProjectNotFoundException;
import com.project.manager.projectmanagerapi.exception.TaskNotFoundException;
import com.project.manager.projectmanagerapi.modal.Task;
import com.project.manager.projectmanagerapi.repository.TaskRepository;
import com.project.manager.projectmanagerapi.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = {"*"})
@RequestMapping("task")
public class TaskController {

    @Autowired
    private TaskRepository taskRepository;

    @Autowired
    private TaskService taskService;

    @PostMapping("/add")
    public ResponseEntity<Task> addTask(@Valid @RequestBody Task task) throws Exception{
        return ResponseEntity.status(HttpStatus.CREATED).body(taskRepository.save(task));
    }


    @PutMapping("/update")
    public ResponseEntity<Task> updateProject(@Valid @RequestBody Task task) throws Exception{
        return ResponseEntity.status(HttpStatus.CREATED).body(taskRepository.save(task));
    }

    @DeleteMapping("/delete/{id}")
    public void deleteProject(@PathVariable  Long id) {
        if(!taskRepository.findById(id).isPresent())
            throw new ProjectNotFoundException("Task not found with id : "+id);
        taskRepository.deleteById(id);
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<Task>> getAllProjects(){
        return ResponseEntity.status(HttpStatus.OK).body(taskRepository.findAll());
    }

    @GetMapping("/")
    public List<Task> getAllTask(){
        return taskRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Task>> getTask(@PathVariable Long id){
        Optional<Task> task = taskRepository.findById(id);
        if(task == null)
            throw new TaskNotFoundException("task does not exit with id : "+id);
        return ResponseEntity.status(HttpStatus.OK).body(task);
    }

}
