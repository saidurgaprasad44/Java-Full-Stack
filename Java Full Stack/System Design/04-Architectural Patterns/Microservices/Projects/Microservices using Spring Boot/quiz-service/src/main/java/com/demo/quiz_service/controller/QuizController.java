package com.demo.quiz_service.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.quiz_service.model.QuestionWrapper;
import com.demo.quiz_service.model.QuizDTO;
import com.demo.quiz_service.model.Response;
import com.demo.quiz_service.service.QuizService;

@RestController
@RequestMapping("quiz")
public class QuizController {
	
	QuizService quizService;
	
	public QuizController(QuizService quizService) {
		this.quizService = quizService;
	}
	
	@PostMapping("create")
	public ResponseEntity<String> createQuiz(@RequestBody QuizDTO quizDTO){
		return quizService.createQuiz(quizDTO);
	}
	
	@GetMapping("get/{id}")
	public ResponseEntity<List<QuestionWrapper>> getQuiz(@PathVariable int id){
		return quizService.getQuiz(id);
	}
	
	@PostMapping("submit/{id}")
	public ResponseEntity<Integer> submitResponse(@PathVariable int id, @RequestBody List<Response> responses){
		return quizService.calculateResult(id, responses);
	}
	
	
}
