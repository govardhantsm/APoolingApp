package com.tyss.ApollingApp.parsing;

import java.util.ArrayList;
import java.util.List;

import com.tyss.ApollingApp.entity.Rating;
import com.tyss.ApollingApp.entity.User;

public class ParseUserDto {
	
	public UserDto parseUserToUserDto(User user)
	{
		UserDto userdto= new UserDto();
		
	}
	
	public List<UserDto> ParseRatingToRatingDto(List<User> listuser)
	{
		List<UserDto> list = new ArrayList<>();
		
		for(Rating rating: listuser)
		{
			list.add(parseRatingToRatingDto(User user));
			
		}
		
		return list;
	}

}
