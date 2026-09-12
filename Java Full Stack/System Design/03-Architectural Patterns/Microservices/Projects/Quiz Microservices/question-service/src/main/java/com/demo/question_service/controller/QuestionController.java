package com.demo.question_service.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.demo.question_service.QuestionServiceApplication;
import com.demo.question_service.model.Question;
import com.demo.question_service.model.QuestionWrapper;
import com.demo.question_service.model.Response;
import com.demo.question_service.service.QuestionService;

@RestController
@RequestMapping("question")
public class QuestionController {

	private QuestionService questionService;
	
	public QuestionController(QuestionService questionService, QuestionServiceApplication questionServiceApplication) {
		this.questionService = questionService;
	}
	
	@GetMapping("wish")
	public String wish() {
		return "hello programmer";
	}
	
	@GetMapping("questions")
	public ResponseEntity<List<Question>> getAllQuestions(){
		return questionService.findAll();
	}
	
	@GetMapping("questions/{category}")
	public ResponseEntity<List<Question>> getQuestionById(@PathVariable String category) {
		return questionService.findByCategory(category);
	}
	
	@PostMapping("questions")
	public ResponseEntity<String> addQuestion(@RequestBody Question question) {
		return questionService.save(question);
	}
	
	
	
	//methods used by quiz-service
	
	//generate questions for a new quiz
	@GetMapping("generate")
	public ResponseEntity<List<Integer>> generateQuizQuestions(@RequestParam String category, @RequestParam int numQ){
		return questionService.generateQuestionsForQuiz(category, numQ);
	}
	
	//get Questions by id list from request body
	@PostMapping("getquestions")
	public ResponseEntity<List<QuestionWrapper>> getQuizQuestions(@RequestBody List<Integer> ids){
		return questionService.getQuestionsForQuiz(ids);
	}
	
	//get participants Score
	@PostMapping("calculatescore")
	public ResponseEntity<Integer> getQuizScore(@RequestBody List<Response> responses){
		return questionService.calulateScore(responses);
	}
	
}
