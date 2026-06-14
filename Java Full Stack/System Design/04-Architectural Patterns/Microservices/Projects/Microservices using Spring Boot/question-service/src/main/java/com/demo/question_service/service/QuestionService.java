package com.demo.question_service.service;

import java.util.ArrayList;
import java.util.List;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.demo.question_service.model.Question;
import com.demo.question_service.model.QuestionWrapper;
import com.demo.question_service.model.Response;
import com.demo.question_service.repo.QuestionRepo;

@Service
public class QuestionService {

	private QuestionRepo questionRepo;

	public QuestionService(QuestionRepo questionRepo) {
		this.questionRepo = questionRepo;
	}

	public ResponseEntity<List<Question>> findAll() {
		try {
			return new ResponseEntity<>(questionRepo.findAll(), HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
	}

	public ResponseEntity<List<Question>> findByCategory(String category) {
		try {
			return new ResponseEntity<>(questionRepo.findByCategory(category), HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
	}

	public ResponseEntity<String> save(Question question) {
		questionRepo.save(question);
		return new ResponseEntity<>("success", HttpStatus.CREATED);
	}

	public ResponseEntity<List<Integer>> generateQuestionsForQuiz(String category, int numQ) {
		List<Integer> quizQuestionIds = questionRepo.findRandomQuestionsByCategory(category, numQ);
		return new ResponseEntity<>(quizQuestionIds, HttpStatus.CREATED);
	}

	public ResponseEntity<List<QuestionWrapper>> getQuestionsForQuiz(List<Integer> ids) {
		Question question = new Question();
		List<QuestionWrapper> wrappers = new ArrayList<>();
		for (int id : ids) {
			question = questionRepo.findById(id).get();
			wrappers.add(new QuestionWrapper(question.getId(), question.getQuestionTitle(), question.getOption_1(),
					question.getOption_2(), question.getOption_3(), question.getOption_4()));
		}
		
		return new ResponseEntity<>(wrappers, HttpStatus.OK);
	}

	public ResponseEntity<Integer> calulateScore(List<Response> responses) {
		
		int score = 0;
		for (Response response : responses) {
			if (response.getResponse().equals(questionRepo.findById(response.getId()).get().getRight_answer())) {
				score++;
			}
		}

		return new ResponseEntity<>(score, HttpStatus.OK);
	}

}
