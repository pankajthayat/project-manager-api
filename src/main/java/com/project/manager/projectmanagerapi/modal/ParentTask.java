package com.project.manager.projectmanagerapi.modal;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class ParentTask {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long parentId;
    private String parentTask;

    @OneToOne(mappedBy = "parentTask", cascade = CascadeType.ALL)
    private Task task;
}
