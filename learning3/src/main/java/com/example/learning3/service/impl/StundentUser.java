package com.example.learning3.service.impl;

import java.util.ArrayList;
import java.util.List;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.learning3.entity.StudentUser;
import com.example.learning3.repository.inf.JpaStudentUser;
import com.example.learning3.service.inf.Userservice;
import com.example.learning3.viewmodel.Userviewmodel;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Service
public class StundentUser implements Userservice{
	
	@Autowired
	JpaStudentUser jpastudentuser;
	
	@Override
	public List<Userviewmodel> allUser() {
		List<StudentUser> allstudent = jpastudentuser.findAll();
		List<Userviewmodel> getAll = new ArrayList<Userviewmodel>();
		
		for(StudentUser student:allstudent) {
			Userviewmodel cvtoModel = new Userviewmodel(student);
			getAll.add(cvtoModel);
		}
		return getAll;		
	}
	
	@Override
	public Boolean postallUser(Userviewmodel student) {
		student.setUserId(UUID.randomUUID().toString());
		StudentUser newstudent =student.toEntity();
		jpastudentuser.save(newstudent);
		return true;		
	}
	
	@Override
	public Boolean putUser(Userviewmodel student) {
		StudentUser userstudent = jpastudentuser.findById(student.getUserId()).orElseThrow();
		userstudent.setUserId(student.getUserId());
		userstudent.setClassName(student.getClassname());
		userstudent.setStudentName(student.getStudentName());
		userstudent.setTecherName(student.getTeacherName());
		jpastudentuser.save(userstudent);
		return true;		
	}
	
	@Override
	public Boolean deleteUser(String id) {
		jpastudentuser.deleteById(id);		
		return true;		
	}
	
	@Override
	public Userviewmodel oneUser(String id) {
		StudentUser student = jpastudentuser.findById(id).orElseThrow();
		Userviewmodel  oneUser = new Userviewmodel();
		oneUser.setUserId(student.getUserId());
		oneUser.setStudentName(student.getStudentName());
		oneUser.setClassname(student.getClassName());
		oneUser.setTeacherName(student.getTecherName());
		return oneUser;		
	}
	
}
