package com.demo.quiz.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.quiz.service.QuestionService;

import com.demo.quiz.model.Question;

@RestController
@RequestMapping("question")
public class QuestionController {
	private QuestionService questionService;
	
	public QuestionController(QuestionService questionService) {
		this.questionService = questionService;
	}
	
	@GetMapping("wish")
	public String wish() {
		return "hello programmer";
	}
	
	@GetMapping("questions")
	public ResponseEntity<List<Question>> findAllQuestions(){
		return questionService.findAll();
	}
	
	@GetMapping("questions/{category}")
	public ResponseEntity<List<Question>> findQuestionById(@PathVariable String category) {
		return questionService.findByCategory(category);
	}
	
	@PostMapping("questions")
	public ResponseEntity<String> addQuestion(@RequestBody Question question) {
		return questionService.save(question);
	}
	
}
