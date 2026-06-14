package com.demo.question_service.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data //a lombok annotation that provides all getters, setters and tostring methods
@NoArgsConstructor
public class Question {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String category;
	private String questionTitle;
	private String option_1;
	private String option_2;
	private String option_3;
	private String option_4;
	private String right_answer;
	private String difficulty_level;
	
	
	
	
}
