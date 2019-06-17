package com.project.manager.projectmanagerapi.modal;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity(name = "TASKS")
public class Task {

    @Id
    @GeneratedValue
    @Column(name = "task_id")
    private Long taskId;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "PROJECT_ID")
    private Project project;
    private  String task;
    private Integer priority;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "PARENT_ID")
    private ParentTask parentTask;
    private Date startDate;
    private Date endDate;

    @OneToOne(mappedBy = "task", cascade = CascadeType.ALL)
    private User user;
}
