package com.project.manager.projectmanagerapi.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ProjectNotFoundException extends  RuntimeException {
    public ProjectNotFoundException(String message) {
        super(message);
    }
}
