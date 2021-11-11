package com.example.learning3.repository.inf;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.learning3.entity.StudentUser;

public interface JpaStudentUser extends JpaRepository<StudentUser, String>{

}
