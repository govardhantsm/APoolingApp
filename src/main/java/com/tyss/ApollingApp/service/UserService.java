package com.tyss.ApollingApp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.tyss.ApollingApp.entity.User;
import com.tyss.ApollingApp.repository.UserRepository;
import com.tyss.ApollingApp.util.GenaratePassword;
import com.tyss.ApollingApp.util.ResponseStructure;

@Service
public class UserService {
	@Autowired
	UserRepository userRepository ;
	
	@Autowired
	GenaratePassword genaratePassword;
	
	public ResponseEntity<ResponseStructure<User>> save(User user)
	{
		user.setUserPassword(genaratePassword.genarateStyring(user.getUserFirstName(), user.getUserPhoneNumber()));
		
		ResponseStructure<User> responseStructure = new ResponseStructure();
		responseStructure.setMessage("Sucess");
		responseStructure.setStatuscode(HttpStatus.CREATED.value());
		responseStructure.setData(user);
		
		return new ResponseEntity<ResponseStructure<User>>(responseStructure,HttpStatus.CREATED);
	}
	

}
