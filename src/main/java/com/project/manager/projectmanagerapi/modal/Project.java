package com.project.manager.projectmanagerapi.modal;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

@Data
@Entity
public class Project {

	@Id
	@GeneratedValue
	@JsonIgnore
	private Long id;

	@NotBlank(message = "project can not be blank")
	private String project;
	
	@FutureOrPresent(message = "start date can not be in past")
	private Date startDate;


	private Date endDate;
	
	@NotNull(message = "priority can not be null")
	private Integer priority;

	@NotBlank(message = "manager can not be blank")
	private String manager;
}
