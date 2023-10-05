package com.tyss.ApollingApp.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Data
public class Rating {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int ratingId;
	private int bodyLanguageScore;
	private String comments;
	private int communicationScore;
	private int confidenceScore;
	private int contentScore;
	private int energyScore;
	private int eyeContactScore;
	private int interationScore;
	private int livelinessScore;
	private double overallRatingScore;
	private boolean status;
	private int usageOfPropsScore;
	private int voiceModulationScore;
	private long PresentationId;

	

	@ManyToOne
	private User voter;
	
	@ManyToOne
	private Presentation presentation ;
	
}
