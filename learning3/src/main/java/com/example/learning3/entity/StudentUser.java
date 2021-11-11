package com.example.learning3.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class StudentUser {
	
	@Id
	private String userId;
	private String studentName;
	private String className;
	private String techerName;
	
}
