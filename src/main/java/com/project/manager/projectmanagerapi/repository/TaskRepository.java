package com.project.manager.projectmanagerapi.repository;

import com.project.manager.projectmanagerapi.modal.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public interface TaskRepository extends JpaRepository<Task, Long> {
}
