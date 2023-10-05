package com.tyss.ApollingApp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.tyss.ApollingApp.dao.UserDao;
import com.tyss.ApollingApp.dto.UserDto;
import com.tyss.ApollingApp.entity.User;
import com.tyss.ApollingApp.exceptions.UserNotFoundException;
import com.tyss.ApollingApp.repository.UserRepository;
import com.tyss.ApollingApp.util.GenaratePassword;
import com.tyss.ApollingApp.util.ResponseStructure;

@Service
public class UserService {
	@Autowired
	UserDao  userDao ;
	
	@Autowired
	GenaratePassword genaratePassword;
	
	public ResponseEntity<ResponseStructure<UserDto>> save(User user)
	{
		user.setUserPassword(genaratePassword.genarateStyring(user.getUserFirstName(), user.getUserPhoneNumber()));
		
	
		ResponseStructure<User> responseStructure = new ResponseStructure();
		responseStructure.setMessage("Sucess");
		responseStructure.setStatuscode(HttpStatus.CREATED.value());
		responseStructure.setData(user);
		
		return new ResponseEntity<ResponseStructure<User>>(responseStructure,HttpStatus.CREATED);
	}
	
	
	  public ResponseEntity<ResponseStructure<UserDto>> findByEmailAndPassword(String email, String password) {
	    	 Optional<User> user = userDao.findByEmailandPassword(email, password) ;
	    	if(user.isPresent()) {
	    	 ResponseStructure<User> responseStructure = new ResponseStructure<>() ;
	    	 responseStructure.setStatuscode(HttpStatus.FOUND.value());
	    	 responseStructure.setMessage("user found");
	    	 responseStructure.setData(user.get());
	    	 return new ResponseEntity<ResponseStructure<User>> (responseStructure,HttpStatus.OK) ;
	    	}
	    	 
	    	else {
	    		throw new UserNotFoundException("user not found") ;
	    	}
	      }
	      
	      public ResponseEntity<ResponseStructure<List<UserDto>>> findAllStudents() {
	    	  List<User> students = userDao.findAllStudents() ;
	    	  if(students.size()>0) {
	    		  ResponseStructure<List<User>> responseStructure = new ResponseStructure<>() ;
	    	    	 responseStructure.setStatuscode(HttpStatus.CREATED.value());
	    	    	 responseStructure.setMessage("user found");
	    	    	 responseStructure.setData(students);
	    	    	 return new ResponseEntity<ResponseStructure<List<UserDto>>> (responseStructure,HttpStatus.OK) ;
	    	  }
	    	  else {
	    		  throw new UserNotFoundException("no users found") ;
	    	  }
	      }
	

}
