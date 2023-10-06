package com.tyss.ApollingApp.parsing;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.tyss.ApollingApp.dto.UserDto;
import com.tyss.ApollingApp.entity.Rating;
import com.tyss.ApollingApp.entity.User;

@Component
public class ParseUserDto {
	
	public UserDto parseUserToUserDto(User user)
	{
		UserDto userdto= new UserDto();
		userdto.setUserId(user.getUserId());
		userdto.setRole(user.getRole());
		userdto.setStatus(user.getStatus());
		userdto.setUserEmail(user.getUserEmail());
		userdto.setUserFirstName(user.getUserFirstName());
		userdto.setUserLastName(user.getUserLastName());

		userdto.setUserPhoneNumber(user.getUserPhoneNumber());
		
		
		return userdto;
	}
	
	public List<UserDto> ParseUserToUserDto(List<User> listuser)
	{
		List<UserDto> list = new ArrayList<>();
		
		for(User user: listuser)
		{
			list.add(parseUserToUserDto(user));
			
		}
		
		return list;
	}

}
