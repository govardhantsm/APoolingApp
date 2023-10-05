package com.tyss.ApollingApp.entity;

import java.util.List;

import com.tyss.ApollingApp.util.Role;
import com.tyss.ApollingApp.util.Status;

import jakarta.annotation.Generated;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int userId;
	private double overAllUserScore;
	private double overallBodyLanguageScore;
	private double overallCommunicationScore;
	private double overallConfidenceScore;
	private double overallContentScore;
	private double overallEnergyScore;
	private double overallEyeScore;
	private double overallInteractionScore;
	private double overallLivelinessScore;
	private double overallUseageOfPropsScore;
	private double overallVoiceModulationScore;
	@Enumerated(EnumType.STRING)
	private Role role;
	@Enumerated(EnumType.STRING)
	private Status status;
	@Column(unique = true)
	private String userEmail;
	private String userFirstName;
	private String userLastName;
	
	private String userPassword;
	@Column(unique = true)
	private String userPhoneNumber;

	@OneToMany
	private List<Presentation> presentations ;
	
	@OneToMany	
	private List<Rating> ratings ;
}
