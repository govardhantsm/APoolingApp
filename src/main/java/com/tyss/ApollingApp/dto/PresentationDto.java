package com.tyss.ApollingApp.dto;

import java.time.LocalDate;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PresentationDto {
    private int presentationId ;
    private LocalDate presentationDate ;
    private String presentationSubject ;
    private String presentationTopic ;
    
    private UserDto presenter ;
}
