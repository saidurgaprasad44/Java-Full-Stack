package com.demo.quiz.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.demo.quiz.repo.QuestionRepo;
import com.demo.quiz.model.Question;

@Service
public class QuestionService {

	private QuestionRepo questionRepo;
	
	public QuestionService(QuestionRepo questionRepo) {
		this.questionRepo = questionRepo;
	}
	
	public ResponseEntity<List<Question>> findAll(){
		try {
			return new ResponseEntity<>(questionRepo.findAll(), HttpStatus.OK);
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
	}
	
	public ResponseEntity<List<Question>> findByCategory(String category){
		try {
			return new ResponseEntity<>(questionRepo.findByCategory(category), HttpStatus.OK);
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
	}
	
	public ResponseEntity<String> save(Question question) {
		questionRepo.save(question);
		return new ResponseEntity<>("success", HttpStatus.CREATED);
	}
}
