package com.tyss.ApollingApp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.tyss.ApollingApp.dao.RatingDao;
import com.tyss.ApollingApp.dto.RatingDto;
import com.tyss.ApollingApp.entity.Presentation;
import com.tyss.ApollingApp.entity.Rating;
import com.tyss.ApollingApp.exceptions.RatingNotFoundException;
import com.tyss.ApollingApp.parsing.ParseRatingDto;
import com.tyss.ApollingApp.util.ResponseStructure;

@Service
public class RatingService {

	@Autowired
	RatingDao ratingDao;
	
	@Autowired
	ParseRatingDto parseRatingDto;
	
	public ResponseEntity<ResponseStructure<RatingDto>> CheckRating(int pid,int uid)
	{
		Rating rating = ratingDao.findByPresentationIdandRatingId(pid, uid);
		
		if(rating!=null)
		{
			ResponseStructure<RatingDto> responseStructure = new ResponseStructure<>();
			responseStructure.setMessage("Found");
			responseStructure.setStatuscode(HttpStatus.FOUND.value());
			responseStructure.setData(parseRatingDto.parseRatingToRatingDto(rating));
			
			return new ResponseEntity(responseStructure,HttpStatus.FOUND);
		}
		else
			throw new RatingNotFoundException("Rating not Found");
	}
	
	public ResponseEntity<ResponseStructure<Rating>> saveRating(Rating rating)
	{
		ResponseStructure<Rating> responseStructure = new ResponseStructure<>();
		responseStructure.setMessage("Sucess");
		responseStructure.setStatuscode(HttpStatus.CREATED.value());
		responseStructure.setData(rating);
		
		return new ResponseEntity(responseStructure,HttpStatus.CREATED);
	}
	
	public ResponseEntity<ResponseStructure<List<Rating>>> findRatingsofStudentByPresentationId(int id) {
		List<Rating> ratings =ratingDao.findRatingByPresentationIdAndStatus(id);
		ResponseStructure<List<Rating>> responseStructure = new ResponseStructure<>();
		responseStructure.setMessage("Found");
		responseStructure.setStatuscode(HttpStatus.FOUND.value());
		responseStructure.setData(ratings);
		return new ResponseEntity<ResponseStructure<List<Rating>>>(responseStructure,HttpStatus.FOUND);
	}
}
