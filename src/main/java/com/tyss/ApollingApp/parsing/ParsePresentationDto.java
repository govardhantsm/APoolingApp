package com.tyss.ApollingApp.parsing;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.stereotype.Component;

import com.tyss.ApollingApp.dto.PresentationDto;
import com.tyss.ApollingApp.entity.Presentation;

@Component
public class ParsePresentationDto {
          
	@Autowired
	ParseUserDto parseUserDto ;
	
	public PresentationDto presentationToPresentationDto(Presentation presentation) {
		PresentationDto presentationDto = new PresentationDto() ;
		presentationDto.setPresentationId(presentation.getPresentationId());
		presentationDto.setPresentationDate(presentation.getPresentationDate());
		presentationDto.setPresentationSubject(presentation.getPresentationSubject());
		presentationDto.setPresentationTopic(presentation.getPresentationTopic());
		presentationDto.setPresenter(parseUserDto.parseUserToUserDto(presentation.getPresenter()));
		return presentationDto ;
	}
}
