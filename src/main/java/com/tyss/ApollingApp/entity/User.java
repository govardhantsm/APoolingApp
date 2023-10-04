package com.tyss.ApollingApp.entity;

import com.tyss.ApollingApp.util.Role;
import com.tyss.ApollingApp.util.Status;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class User {
 int user_id;
 double over_all_user_score;
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
 Role role;
 Status status;
 String user_email;
 String user_first_name;
 String user_last_name;
 String user_password;
 String user_phone_number;
}
