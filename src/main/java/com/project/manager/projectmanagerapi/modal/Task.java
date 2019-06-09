package com.project.manager.projectmanagerapi.modal;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

@Data
@Entity(name = "TASKS")
public class Task {

    @Id
    private Long id;
    private String project;
    private  String task;
    private Integer priority;
    private String parentTask;
    private Date startDate;
    private Date endDate;
    private String user;
}
