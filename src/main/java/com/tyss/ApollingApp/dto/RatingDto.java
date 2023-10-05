package com.tyss.ApollingApp.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RatingDto {
    private int ratingId ;
    private String comments ;
    private double overAllRatingScore ;
    private String role ;
    private PresentationDto presentationDto ;
}
