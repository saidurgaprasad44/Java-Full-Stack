package com.demo.quiz_service.feign;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.demo.quiz_service.config.FeignSecurityConfig;
import com.demo.quiz_service.dto.QuestionWrapper;
import com.demo.quiz_service.dto.Response;

@FeignClient(
	    name = "QUESTION-SERVICE",
	    configuration = FeignSecurityConfig.class
	)
public interface QuizFeign {
	
	//generate questions for a new quiz
	@GetMapping("questions/generate")
	public ResponseEntity<List<Integer>> generateQuizQuestions(@RequestParam String category, @RequestParam int numQ);
	
	//get Questions by id list from request body
	@PostMapping("questions/quiz")
	public ResponseEntity<List<QuestionWrapper>> getQuizQuestions(@RequestBody List<Integer> ids);
	
	//get participants Score
	@PostMapping("questions/calculatescore")
	public ResponseEntity<Integer> getQuizScore(@RequestBody List<Response> responses);
}
