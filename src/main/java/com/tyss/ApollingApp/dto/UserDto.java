package com.tyss.ApollingApp.dto;

import com.tyss.ApollingApp.util.Role;
import com.tyss.ApollingApp.util.Status;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDto {
    private int userId ;
    private Role role ;
    private Status status ;
    private String userEmail ;
    private String userFirstName ;
    private String userLastName ;
  
    private long userPhoneNumber ;
    
}
