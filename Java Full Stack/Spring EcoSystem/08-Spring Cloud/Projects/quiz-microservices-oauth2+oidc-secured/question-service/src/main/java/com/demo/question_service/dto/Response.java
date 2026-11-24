package com.demo.question_service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data //a lombok annotation that provides all getters, setters and tostring methods
@AllArgsConstructor 
public class Response {
	private int id;
	private String response;
	
	
}
