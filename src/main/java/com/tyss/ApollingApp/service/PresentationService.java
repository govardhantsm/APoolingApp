package com.tyss.ApollingApp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.tyss.ApollingApp.dao.PresentationDao;
import com.tyss.ApollingApp.entity.Presentation;
import com.tyss.ApollingApp.util.ResponseStructure;

@Service
public class PresentationService {

	@Autowired
	PresentationDao dao;
	
	public ResponseEntity<ResponseStructure<List<Presentation>>> findCompletedPresentations(int id)
	{
		ResponseStructure<List<Presentation>> responseStructure = new ResponseStructure<>();
		responseStructure.setMessage("Found");
		responseStructure.setStatuscode(HttpStatus.FOUND.value());
		responseStructure.setData(dao.findCompletedPresentation(id));
		return new ResponseEntity<ResponseStructure<List<Presentation>>>(responseStructure, HttpStatus.FOUND);
	}
}
