package com.demo.quiz_service.feign;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.demo.quiz_service.model.QuestionWrapper;
import com.demo.quiz_service.model.Response;

@FeignClient("QUESTION-SERVICE")
public interface QuizFeign {
	
	//generate questions for a new quiz
	@GetMapping("question/generate")
	public ResponseEntity<List<Integer>> generateQuizQuestions(@RequestParam String category, @RequestParam int numQ);
	
	//get Questions by id list from request body
	@PostMapping("question/getquestions")
	public ResponseEntity<List<QuestionWrapper>> getQuizQuestions(@RequestBody List<Integer> ids);
	
	//get participants Score
	@PostMapping("question/calculatescore")
	public ResponseEntity<Integer> getQuizScore(@RequestBody List<Response> responses);
}
