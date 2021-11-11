package com.example.learning3.viewmodel;

import com.example.learning3.entity.StudentUser;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Userviewmodel {
	private String userId;
	private String studentName;
	private String classname;
	private String teacherName;
	
	public Userviewmodel() {
		
	}
	
	public Userviewmodel(StudentUser studentuser) {
		this.userId = studentuser.getUserId();
		this.studentName = studentuser.getStudentName();
		this.classname = studentuser.getClassName();
		this.teacherName = studentuser.getTecherName();
	}
	
	public StudentUser toEntity() {
		StudentUser recentEntity = new StudentUser();
		recentEntity.setUserId(this.userId);
		recentEntity.setStudentName(this.studentName);
		recentEntity.setClassName(this.classname);
		recentEntity.setTecherName(this.teacherName);
		return recentEntity;
	}
}
