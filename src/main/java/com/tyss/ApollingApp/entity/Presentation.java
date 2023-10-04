package com.tyss.ApollingApp.entity;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;

import com.tyss.ApollingApp.util.Status;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;
@Entity
@Getter
@Setter
public class Presentation {
int presentation_id;
double over_all_presentation_score;
double overall_body_language_score;
double overall_communication_score; 
double overall_confidence_score; 
double overall_content_score; 
double overall_energy_score;
double overall_eye_score;
double overall_interaction_score;
double overall_liveliness_score;
double overall_useage_of_props_score;
double overall_voice_modulation_score;
LocalDate presentation_date;
String presentation_subject;
LocalTime presentation_time;
String presentation_topic;
Status status;
int voter_count;
User presenter;

}
