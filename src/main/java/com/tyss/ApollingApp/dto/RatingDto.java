package com.tyss.ApollingApp.dto;

import com.tyss.ApollingApp.util.Role;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RatingDto {
    private int ratingId ;
    private String comments ;
    private double overAllRatingScore ;
    private Role role ;
    private PresentationDto presentationDto ;
}
