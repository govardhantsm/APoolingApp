package com.tyss.ApollingApp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tyss.ApollingApp.dto.UserDto;
import com.tyss.ApollingApp.entity.Presentation;
import com.tyss.ApollingApp.entity.User;
import com.tyss.ApollingApp.service.AdminService;

import com.tyss.ApollingApp.util.Login;
import com.tyss.ApollingApp.util.ResponseStructure;
import com.tyss.ApollingApp.util.Status;

@RestController
public class AdminController {
	@Autowired
	AdminService service;

	@PostMapping("/login")
	public ResponseEntity<ResponseStructure<UserDto>> login(@RequestBody Login login) {
		return service.findByEmailAndPassword(login.getEmail(), login.getPassword());
	}

	@GetMapping("/viewAllStudents")
	public ResponseEntity<ResponseStructure<List<UserDto>>> findAllStudents() {
		return service.findAllStudents();
	}

	@PostMapping("/save")
	public ResponseEntity<ResponseStructure<UserDto>> saveUser(@RequestBody User user) {
		return service.save(user);
	}
	
	@GetMapping("/findongoingpresentations")
	public ResponseEntity<ResponseStructure<List<Presentation>>> findOngoingPresentations() {
		return service.findOngoingPresentation() ;
	}

	@GetMapping("/randomTrainee")
	public ResponseEntity<ResponseStructure<User>> randomTrainee() {
		return service.randomTrainee() ;
	}
	
	@PostMapping("/assignPresentation")
	public ResponseEntity<ResponseStructure<Presentation>> savePresentation(@RequestBody Presentation presentation, @RequestParam int uid) {
		return service.assignPresentation(presentation, uid) ;
	}

	@PutMapping("/startvoting")            
	public void startVoting(@RequestBody Presentation presentation) {
		service.startVoting(presentation) ;
	}
	
	@PutMapping("/endvoting")
	public void endVoting(@RequestParam int pid, @RequestParam Status status) {
		service.endVoting(pid, status) ;
	}
}
