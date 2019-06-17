package com.project.manager.projectmanagerapi.modal;

import java.util.Date;

import javax.persistence.*;
import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.hibernate.annotations.Cascade;

@Data
@Entity(name = "PROJECTS")
public class Project {

	@Id
	@GeneratedValue
	@Column(name = "project_id")
	private Long projectId;

	@NotBlank(message = "project can not be blank")
	private String project;
	
	//@FutureOrPresent(message = "start date can not be in past")
	private Date startDate;


	@OneToOne(mappedBy = "project", cascade = CascadeType.ALL)
	private User manager;

	@OneToOne(mappedBy = "project", cascade = CascadeType.ALL)
	private Task task;

	private Date endDate;
	
	@NotNull(message = "priority can not be null")
	private Integer priority;

}
