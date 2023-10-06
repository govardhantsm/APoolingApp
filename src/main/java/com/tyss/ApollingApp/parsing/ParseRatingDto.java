package com.tyss.ApollingApp.parsing;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.tyss.ApollingApp.dto.RatingDto;
import com.tyss.ApollingApp.entity.Rating;

@Component
public class ParseRatingDto {

	@Autowired
	 ParsePresentationDto parsePresentationDto;
	
	
	
	public RatingDto parseRatingToRatingDto(Rating rating)
	{
		RatingDto ratingdto= new RatingDto();
		ratingdto.setRatingId(rating.getRatingId());
		ratingdto.setPresentationDto(parsePresentationDto.presentationToPresentationDto(rating.getPresentation()));
		ratingdto.setComments(rating.getComments());
		ratingdto.setOverAllRatingScore(rating.getOverallRatingScore());
		ratingdto.setRole(rating.getVoter().getRole());
		return ratingdto;
	}
	
	public List<RatingDto> ParseRatingToRatingDto(List<Rating> listrating)
	{
		List<RatingDto> list = new ArrayList<>();
		
		for(Rating rating: listrating)
		{
			list.add(parseRatingToRatingDto(rating));
			
		}
		
		return list;
	}
}
