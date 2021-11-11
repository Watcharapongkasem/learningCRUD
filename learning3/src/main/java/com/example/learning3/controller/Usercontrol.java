package com.example.learning3.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.learning3.service.inf.Userservice;
import com.example.learning3.viewmodel.Userviewmodel;


@RestController
@RequestMapping("api/user")
@CrossOrigin(origins = "*",allowedHeaders = "*")
public class Usercontrol {
	
	@Autowired
	private Userservice userservice;
	
	@GetMapping("get-all")
	public ResponseEntity<List<Userviewmodel>> getAllUser(){
		List<Userviewmodel> result = userservice.allUser();
		return new ResponseEntity<List<Userviewmodel>>(result,HttpStatus.OK);
	}
	
	@PostMapping("post-student")
	public ResponseEntity<Boolean> postAllUser(@RequestBody Userviewmodel postAll){
		Boolean result = userservice.postallUser(postAll);
		return new ResponseEntity<Boolean>(result,HttpStatus.CREATED);
	}
	
	@PutMapping("put-student")
	public ResponseEntity<Boolean> putUser(@RequestBody Userviewmodel postAll){
		Boolean result = userservice.putUser(postAll);
		return new ResponseEntity<Boolean>(result,HttpStatus.CREATED);
	}
	
	@DeleteMapping("delete-student/{id}")
	public ResponseEntity<Boolean> deleteUser(@PathVariable("id") String id){
		Boolean result = userservice.deleteUser(id);
		return new ResponseEntity<Boolean>(result,HttpStatus.OK);
	}
	
	@GetMapping("get-one/{id}")
	public ResponseEntity<Userviewmodel> getOneUser(@PathVariable("id") String id){
		Userviewmodel result = userservice.oneUser(id);
		return new ResponseEntity<Userviewmodel>(result,HttpStatus.OK);
	}
	
}
