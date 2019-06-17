package com.project.manager.projectmanagerapi.modal;

import java.util.Date;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.NaturalId;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Entity
@Data
@Table(name = "USERS")
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "USER_ID")
	private Long userId;
	
	@Size(min=1, message = "please enter last name")
	private String firstName;
	
	@NotBlank(message = "please enter last name")
	private String lastName;
	
	@NotNull(message = "please enter employee id")
	@NaturalId
	private Long employeeId;




	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "PROJECT_ID")
	private Project project;

//	@OneToOne(cascade = CascadeType.ALL)
//	@JoinColumn(name = "task_id", referencedColumnName = "task_id")
@OneToOne(cascade = CascadeType.ALL)
@JoinColumn(name = "TASK_ID")
	private Task task;
//
//	@JsonIgnore
//	@CreationTimestamp
//	@Temporal(TemporalType.TIMESTAMP)
//	private Date createdAt;
}
