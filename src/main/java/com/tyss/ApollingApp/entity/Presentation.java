package com.tyss.ApollingApp.entity;

import java.time.LocalDate;

import java.time.LocalTime;
import java.util.Date;
import java.util.List;

import org.hibernate.annotations.CreationTimestamp;

import com.tyss.ApollingApp.util.Status;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Presentation {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int presentationId;
	private double overAllPresentationScore;
	private double overallBodyLanguageScore;
	private double overallCommunicationScore;
	private double overallConfidenceScore;
	private double overallContentScore;
	private double overallEnergyScore;
	private double overallEyescore;
	private double overallInteractionScore;
	private double overallLivelinessScore;
	private double overallUseageOfPropsScore;
	private double overallVoiceModulationScore;
	@CreationTimestamp
	private LocalDate presentationDate;
	private LocalTime presentationTime;
	private String presentationSubject;
	private String presentationTopic;
	@Enumerated(EnumType.STRING)
	private Status status;
	private int voterCount;
	@ManyToOne
	@JoinColumn(name = "presenterUserId")
	private User presenter;
	@OneToMany
	private List<Rating> ratings;

}
