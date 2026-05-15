package com.demo.quiz.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.demo.quiz.model.QuestionWrapper;
import com.demo.quiz.model.Reponse;
import com.demo.quiz.service.QuizService;

@RestController
@RequestMapping("quiz")
public class QuizController {
	
	QuizService quizService;
	
	public QuizController(QuizService quizService) {
		this.quizService = quizService;
	}
	
	@GetMapping("get/{id}")
	public ResponseEntity<List<QuestionWrapper>> getQuiz(@PathVariable int id){
		return quizService.getQuiz(id);
	}
	
	@PostMapping("create")
	public ResponseEntity<String> createQuiz(@RequestParam String category, @RequestParam int numQ, @RequestParam String title){
		System.out.println(category+numQ+title);
		return quizService.createQuiz(category, numQ, title);
	}
	
	@PostMapping("submit/{id}")
	public ResponseEntity<Integer> submitResponse(@PathVariable int id, @RequestBody List<Reponse> responses){
		return quizService.calculateResult(id, responses);
	}
	
	
}
