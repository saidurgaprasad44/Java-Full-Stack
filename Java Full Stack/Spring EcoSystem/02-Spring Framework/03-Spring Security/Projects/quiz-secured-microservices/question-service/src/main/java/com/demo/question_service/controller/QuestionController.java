package com.demo.question_service.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.demo.question_service.dto.QuestionWrapper;
import com.demo.question_service.dto.Response;
import com.demo.question_service.entity.Question;
import com.demo.question_service.service.QuestionService;

@RestController
@RequestMapping("questions")
public class QuestionController {

	private QuestionService questionService;
	
	public QuestionController(QuestionService questionService) {
		this.questionService = questionService;
	}
	
	@GetMapping("test")
	public String wish() {
		return "hello programmer";
	}
	
	@GetMapping
	@PreAuthorize("hasRole('TUTOR')")
	public ResponseEntity<List<Question>> getAllQuestions(){
		return questionService.findAll();
	}
	
	@GetMapping("/{category}")
	@PreAuthorize("hasRole('TUTOR')")
	public ResponseEntity<List<Question>> getQuestionById(@PathVariable String category) {
		return questionService.findByCategory(category);
	}
	
	@PostMapping
	@PreAuthorize("hasRole('TUTOR')")
	public ResponseEntity<String> addQuestion(@RequestBody Question question) {
		return questionService.save(question);
	}
	
	@DeleteMapping("/{id}")
	@PreAuthorize("hasRole('TUTOR')")
	public ResponseEntity<String> deleteQuestion(@PathVariable int id) {
		return questionService.delete(id);
	}
	
	
	
	//methods used by quiz-service
	
	//get random question ids for a new quiz
	@GetMapping("generate")
	@PreAuthorize("hasRole('TUTOR')")
	public ResponseEntity<List<Integer>> generateQuizQuestions(@RequestParam String category, @RequestParam int numQ){
		
		return questionService.generateQuestionsForQuiz(category, numQ);
	}
	
	//get QuestionWrappers by list of questions ids from request body
	@PostMapping("quiz")
	public ResponseEntity<List<QuestionWrapper>> getQuizQuestions(@RequestBody List<Integer> ids){
		return questionService.getQuestionsForQuiz(ids);
	}
	
	//get Score
	@PostMapping("calculatescore")
	public ResponseEntity<Integer> getQuizScore(@RequestBody List<Response> responses){
		return questionService.calulateScore(responses);
	}
	
}
