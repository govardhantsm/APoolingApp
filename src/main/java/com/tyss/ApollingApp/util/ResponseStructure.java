package com.tyss.ApollingApp.util;

import java.util.List;

import com.tyss.ApollingApp.entity.User;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ResponseStructure<T> {
     int statuscode ;
     String message ;
     T data ;
}
