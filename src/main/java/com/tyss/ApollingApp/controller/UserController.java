package com.tyss.ApollingApp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tyss.ApollingApp.dto.RatingDto;
import com.tyss.ApollingApp.dto.UserDto;
import com.tyss.ApollingApp.entity.Presentation;
import com.tyss.ApollingApp.entity.Rating;
import com.tyss.ApollingApp.entity.User;
import com.tyss.ApollingApp.service.PresentationService;
import com.tyss.ApollingApp.service.RatingService;
import com.tyss.ApollingApp.service.UserService;
import com.tyss.ApollingApp.util.Login;
import com.tyss.ApollingApp.util.ResponseStructure;

@RestController
public class UserController {

	@Autowired
	UserService service;
	
	@Autowired
	RatingService ratingService;
	@Autowired
	PresentationService presentationService;

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

	@GetMapping("/checkRating")
	public ResponseEntity<ResponseStructure<RatingDto>> checkRatings(@RequestParam int presentationId, @RequestParam int userId )
	{
		return ratingService.CheckRating(presentationId, userId);
	}
	
	@PostMapping("/saveRating")
	public ResponseEntity<ResponseStructure<Rating>> saveRating(@RequestBody Rating rating)
	{
		return ratingService.saveRating(rating);
	}
	
	@GetMapping("/completedPresentations")
	public ResponseEntity<ResponseStructure<List<Presentation>>> findCompletedPresentations(@RequestParam int id)
	{
		return presentationService.findCompletedPresentations(id);
	}
	
	@GetMapping("/getRatings")
	public ResponseEntity<ResponseStructure<List<Rating>>> findRatingsofthestudentPresentationId(@RequestParam int id)
	{
		return ratingService.findRatingsofStudentByPresentationId(id);
	}

}
