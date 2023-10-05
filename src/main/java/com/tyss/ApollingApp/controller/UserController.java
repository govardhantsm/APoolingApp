package com.tyss.ApollingApp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.tyss.ApollingApp.entity.User;
import com.tyss.ApollingApp.service.UserService;
import com.tyss.ApollingApp.util.Login;
import com.tyss.ApollingApp.util.ResponseStructure;

public class UserController {

	@Autowired
	UserService service ;
	
	@PostMapping("/login")
	public ResponseEntity<ResponseStructure<User>> login(@RequestBody Login login) {
		return service.findByEmailAndPassword(login.getEmail(), login.getPassword()) ;
	}
	
	@PostMapping("/viewAllStudents")
	public ResponseEntity<ResponseStructure<List<User>>> findAllStudents() {
		return service.findAllStudents() ;
	}
	
	@PostMapping("/save")
	public ResponseEntity<ResponseStructure<User>> login(@RequestBody User user) {
		return service.save(user) ;
	} 
}
