package com.tyss.ApollingApp.service;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.tyss.ApollingApp.dao.PresentationDao;
import com.tyss.ApollingApp.dao.RatingDao;
import com.tyss.ApollingApp.dao.UserDao;
import com.tyss.ApollingApp.dto.UserDto;
import com.tyss.ApollingApp.entity.Presentation;
import com.tyss.ApollingApp.entity.Rating;
import com.tyss.ApollingApp.entity.User;
import com.tyss.ApollingApp.exceptions.PresentationNotFoundException;
import com.tyss.ApollingApp.exceptions.UserNotFoundException;
import com.tyss.ApollingApp.parsing.ParsePresentationDto;
import com.tyss.ApollingApp.parsing.ParseRatingDto;
import com.tyss.ApollingApp.parsing.ParseUserDto;
import com.tyss.ApollingApp.repository.UserRepository;
import com.tyss.ApollingApp.util.GenaratePassword;
import com.tyss.ApollingApp.util.ResponseStructure;
import com.tyss.ApollingApp.util.Status;

@Service
public class AdminService {
	@Autowired
	UserDao  userDao ;
	
	@Autowired
	GenaratePassword genaratePassword;
	
	@Autowired
	ParseUserDto parseUserDto ;
	
	@Autowired
	ParseRatingDto parseRatingDto ;
	
	@Autowired
	ParsePresentationDto parsePresentationDto ;
	
	@Autowired
	PresentationDao presentationDao ;
	
	@Autowired
	RatingDao ratingDao ;
	
	public ResponseEntity<ResponseStructure<UserDto>> save(User user)
	{
		user.setUserPassword(genaratePassword.genarateString(user.getUserFirstName(),Long.toString(user.getUserPhoneNumber()) ));

		userDao.save(user);
        
		ResponseStructure<UserDto> responseStructure = new ResponseStructure();
		responseStructure.setMessage("Sucess");
		responseStructure.setStatuscode(HttpStatus.CREATED.value());
		responseStructure.setData(parseUserDto.parseUserToUserDto(user));
		
		return new ResponseEntity<ResponseStructure<UserDto>>(responseStructure,HttpStatus.CREATED);
	}
	
	
	  public ResponseEntity<ResponseStructure<UserDto>> findByEmailAndPassword(String email, String password) {
	    	 Optional<User> user = userDao.findByEmailandPassword(email, password) ;
	    	if(user.isPresent()) {
	    	 ResponseStructure<UserDto> responseStructure = new ResponseStructure<>() ;
	    	 responseStructure.setStatuscode(HttpStatus.FOUND.value());
	    	 responseStructure.setMessage("user found");
	    	 responseStructure.setData(parseUserDto.parseUserToUserDto(user.get()));
	    	 return new ResponseEntity<ResponseStructure<UserDto>> (responseStructure,HttpStatus.OK) ;
	    	}
	    	 
	    	else {
	    		throw new UserNotFoundException("user not found") ;
	    	}
	      }
	      
	      public ResponseEntity<ResponseStructure<List<UserDto>>> findAllStudents() {
	    	  List<User> students = userDao.findAllStudents() ;
	    	  if(students.size()>0) {
	    		  ResponseStructure<List<UserDto>> responseStructure = new ResponseStructure<>() ;
	    	    	 responseStructure.setStatuscode(HttpStatus.CREATED.value());
	    	    	 responseStructure.setMessage("user found");
	    	    	 responseStructure.setData(parseUserDto.ParseUserToUserDto(students));
	    	    	 return new ResponseEntity<ResponseStructure<List<UserDto>>> (responseStructure,HttpStatus.OK) ;
	    	  }
	    	  else {
	    		  throw new UserNotFoundException("no users found") ;
	    	  }
	      }
	      
	      public ResponseEntity<ResponseStructure<List<Presentation>>> findOngoingPresentation() {
	    	  List<Presentation> ongoingPresentations = presentationDao.findOngoingPresentation() ;
	    	  if(ongoingPresentations.size()>0) {
	    		  ResponseStructure<List<Presentation>> responseStructure = new ResponseStructure<>() ;
	    		  responseStructure.setMessage("presentations found");
	    		  responseStructure.setStatuscode(HttpStatus.FOUND.value());
	    		  responseStructure.setData(ongoingPresentations);
	    		  
	    		  return new ResponseEntity<ResponseStructure<List<Presentation>>> (responseStructure, HttpStatus.FOUND) ;
	    	  }
	    	  
	    	  else {
	    		  throw new PresentationNotFoundException("no presentations found") ;
	    	  }
	      }
	      
	     
	      
	      public ResponseEntity<ResponseStructure<User>> randomTrainee() {
	    	  List<User> students = userDao.findAllStudents() ;
	    	  Collections.shuffle(students);
	    	  
	    	  System.out.println(students);
	    	  User user = students.get(0);
	    	  System.out.println(user);
	    	  ResponseStructure<User> responseStructure = new ResponseStructure<>() ;
	    	  responseStructure.setStatuscode(HttpStatus.FOUND.value());
	    	  responseStructure.setMessage("random trainee found");
	    	  responseStructure.setData(user);
	    	  
	    	  return new ResponseEntity<ResponseStructure<User>>(responseStructure, HttpStatus.FOUND) ;
	      }
	
	      public ResponseEntity<ResponseStructure<Presentation>> assignPresentation(Presentation presentation, int uid) {
	    	  User user = userDao.findById(uid) ;
	    	  List<Presentation> presentations = user.getPresentations() ;
	    	  presentations.add(presentation) ;
	    	  
	    	  user.setPresentations(presentations);
	    	  presentation.setPresenter(user);
	    	  
	    	  userDao.save(user) ;
	    	  
	    	  ResponseStructure<Presentation> responseStructure = new ResponseStructure<>() ;
	    	  responseStructure.setStatuscode(HttpStatus.ACCEPTED.value());
	    	  responseStructure.setMessage("data saved");
	    	  responseStructure.setData(presentation); 
	    	  
	    	  List<User> students = userDao.findAllStudents() ;
	    	  for(User users : students) {
	    		  if(users.getUserId()!=user.getUserId()) {
//	    		  User user1 = new User() ;
//	    		  user1.setOverallBodyLanguageScore(users.getOverallBodyLanguageScore());
//	    		  user1.setOverallCommunicationScore(users.getOverallCommunicationScore());
//	    		  user1.setOverallConfidenceScore(users.getOverallConfidenceScore());
//	    		  user1.setOverallContentScore(users.getOverallContentScore());
//	    		  user1.setOverallEnergyScore(users.getOverallEnergyScore());
//	    		  user1.setOverallEyeScore(users.getOverallEyeScore());
//	    		  user1.setOverallInteractionScore(users.getOverallInteractionScore());
//	    		  user1.setOverallLivelinessScore(users.getOverallLivelinessScore());
//	    		  user1.setOverallUseageOfPropsScore(users.getOverallUseageOfPropsScore());
//	    		  user1.setOverAllUserScore(users.getOverAllUserScore());
//	    		  user1.setOverallVoiceModulationScore(users.getOverallVoiceModulationScore());
//	    		  user1.setPresentations(users.getPresentations());
//	    		  user1.setRatings(users.getRatings());
//	    		  user1.setRole(users.getRole());
//	    		  user1.setStatus(users.getStatus());
//	    		  user1.setUserEmail(users.getUserEmail());
//	    		  user1.setUserFirstName(users.getUserFirstName());
//	    		  user1.setUserId(users.getUserId());
//	    		  user1.setUserLastName(users.getUserLastName());
//	    		  user1.setUserPassword(users.getUserPassword());
//	    		  user1.setUserPhoneNumber(users.getUserPhoneNumber());
//	    		  
	    		  Rating r = new Rating() ;
	    		  r.setVoter(users);
	    		  r.setPresentation(presentation);
	    		  List<Rating> ratings = users.getRatings() ;
	    		  ratings.add(r) ;
	    		  users.setRatings(ratings);
	    		  
	    		  userDao.save(users) ;
	    		  }
	    		  
	    	  }
	    	  return new ResponseEntity<ResponseStructure<Presentation>>(responseStructure, HttpStatus.ACCEPTED) ;
	    	  
	      }
	      
	      public void startVoting(Presentation presentation) {
	    	 Presentation presentation2 = presentationDao.findByPresentationId(presentation.getPresentationId()) ;
	    	 presentation2.setPresentationTime(presentation.getPresentationTime());
	    	 presentation2.setStatus(presentation.getStatus());
	    	 
	    	 presentationDao.savePresentation(presentation2) ;
	      }
	      
	      
	      public void endVoting(int pid, Status status) {
	    	  Presentation presentation = presentationDao.findByPresentationId(pid) ;
	    	  presentation.setStatus(status);
	      }

}
