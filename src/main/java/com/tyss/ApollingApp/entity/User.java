package com.tyss.ApollingApp.entity;

import com.tyss.ApollingApp.util.Role;
import com.tyss.ApollingApp.util.Status;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class User {
	private int user_id;
	private double over_all_user_score;
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
	@Enumerated(EnumType.STRING)
	private Role role;
	@Enumerated(EnumType.STRING)
	private Status status;
	private String user_email;
	private String user_first_name;
	private String user_last_name;
	private String user_password;
	private String user_phone_number;

}
