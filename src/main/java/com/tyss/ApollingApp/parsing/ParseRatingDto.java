package com.tyss.ApollingApp.parsing;

import java.util.ArrayList;
import java.util.List;

import com.tyss.ApollingApp.entity.Rating;

public class ParseRatingDto {

	public RatingDto parseRatingToRatingDto(Rating rating)
	{
		RatingDto ratingdto= new RatingDto();
		return ratingdto;
	}
	
	public List<RatingDto> ParseRatingToRatingDto(List<Rating> listrating)
	{
		List<RatingDto> list = new ArrayList<>();
		
		for(Rating rating: listrating)
		{
			list.add(parseRatingToRatingDto(Rating rating));
			
		}
		
		return list;
	}
}
