package com.demo.quiz_service.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data //a lombok annotation that provides all getters, setters and tostring methods
@AllArgsConstructor
public class QuestionWrapper {
	private int id;
	private String questionTitle;
	private String option_1;
	private String option_2;
	private String option_3;
	private String option_4;
	
	
	
}
