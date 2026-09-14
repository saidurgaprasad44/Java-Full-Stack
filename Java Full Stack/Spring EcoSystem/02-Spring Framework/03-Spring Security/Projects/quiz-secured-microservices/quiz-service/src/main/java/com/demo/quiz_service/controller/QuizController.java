package com.demo.quiz_service.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.quiz_service.dto.QuestionWrapper;
import com.demo.quiz_service.dto.QuizDTO;
import com.demo.quiz_service.dto.Response;
import com.demo.quiz_service.service.QuizService;

@RestController
@RequestMapping("quiz")
public class QuizController {
	
	QuizService quizService;
	
	public QuizController(QuizService quizService) {
		this.quizService = quizService;
	}
	
	//test endpoint to check if the service is running
	@GetMapping("test")
	public String wish() {
		return "hello programmer";
	}
	
	//tutor creates a new quiz with title, category and number of questions
	@PostMapping
	@PreAuthorize("hasRole('TUTOR')")
	public ResponseEntity<String> createQuiz(@RequestBody QuizDTO quizDTO){
		return quizService.createQuiz(quizDTO);
	}
	
	//tutor deletes a quiz by quiz id
	@DeleteMapping("/{id}")
	@PreAuthorize("hasRole('TUTOR')")
	public ResponseEntity<String> deleteQuiz(@PathVariable int id){
		return quizService.deleteQuiz(id);
	}
	
	//anyone can get the questions for a quiz by quiz id
	@GetMapping("/{id}")
	//@PreAuthorize("hasAnyRole('STUDENT', 'TUTOR')")// not needed as it is configured that anyone authenticated can access the quiz
	public ResponseEntity<List<QuestionWrapper>> getQuiz(@PathVariable int id){
		return quizService.getQuiz(id);
	}
	
	//anyone can submit the responses for a quiz and get the score
	@PostMapping("submit/{id}")
	//@PreAuthorize("hasAnyRole('STUDENT', 'TUTOR')")// not needed as it is configured that anyone authenticated can access the quiz
	public ResponseEntity<Integer> submitResponse(@PathVariable int id, @RequestBody List<Response> responses){
		return quizService.calculateResult(id, responses);
	}
	
}
