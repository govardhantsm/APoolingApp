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
	private int rating_id;
	private int body_language_score;
	private String comments;
	private int communication_score;
	private int confidence_score;
	private int content_score;
	private int energy_score;
	private int eye_contact_score;
	private int interation_score;
	private int liveliness_score;
	private double over_all_rating_score;
	private boolean status;
	private int usage_of_props_score;
	private int voice_modulation_score;
	private long presentation_presentation_id;

	private long voter_user_id;

	@ManyToOne
	private User user;
}
