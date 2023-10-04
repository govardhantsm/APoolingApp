package com.tyss.ApollingApp.entity;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;

import com.tyss.ApollingApp.util.Status;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Getter;
import lombok.Setter;
@Entity
@Getter
@Setter
public class Presentation {

private int presentation_id;
private double over_all_presentation_score;
private double overall_body_language_score;
private double overall_communication_score; 
private double overall_confidence_score; 
private double overall_content_score; 
private double overall_energy_score;
private double overall_eye_score;
private double overall_interaction_score;
private double overall_liveliness_score;
private double overall_useage_of_props_score;
private double overall_voice_modulation_score;
private LocalDate presentation_date;
private String presentation_subject;
private LocalTime presentation_time;
private String presentation_topic;
@Enumerated(EnumType.STRING)
private Status status;
private int voter_count;
private User presenter;


}
