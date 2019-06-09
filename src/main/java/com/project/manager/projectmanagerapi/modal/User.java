package com.project.manager.projectmanagerapi.modal;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.NaturalId;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Entity
@Data
@Table(name = "USERS")
public class User {
	
	@Id
	@GeneratedValue
	private Long id;
	
	@Size(min=1, message = "please enter last name")
	private String firstName;
	
	@NotBlank(message = "please enter last name")
	private String lastName;
	
	@NotNull(message = "please enter employee id")
	@NaturalId
	private Long employeeId;
	
	@JsonIgnore
	@CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	private Date createdAt;
}
