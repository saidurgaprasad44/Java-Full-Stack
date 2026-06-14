package com.demo.quiz_service.service;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.demo.quiz_service.model.Quiz;
import com.demo.quiz_service.model.QuizDTO;
import com.demo.quiz_service.model.Response;
import com.demo.quiz_service.repo.QuizRepo;
import com.demo.quiz_service.model.QuestionWrapper;
import com.demo.quiz_service.feign.QuizFeign;

@Service
public class QuizService {

	QuizRepo quizRepo;
	QuizFeign quizFeign;

	public QuizService(QuizRepo quizRepo, QuizFeign quizFeign) {
		this.quizRepo = quizRepo;
		this.quizFeign = quizFeign;
	}

	public ResponseEntity<String> createQuiz(QuizDTO quizDTO) {
		List<Integer> questionIds = quizFeign.generateQuizQuestions(quizDTO.getCategory(), quizDTO.getNumberOfQuestions()).getBody();
		Quiz quiz = new Quiz();
		quiz.setTitle(quizDTO.getTitle());
		quiz.setQuestionIds(questionIds);
		quizRepo.save(quiz);
		return new ResponseEntity<>("success", HttpStatus.CREATED);
	}

	public ResponseEntity<List<QuestionWrapper>> getQuiz(int id) {
		List<Integer> questionIds = quizRepo.findById(id).get().getQuestionIds();

		ResponseEntity<List<QuestionWrapper>> questionsForUser = quizFeign.getQuizQuestions(questionIds);

		return questionsForUser;
	}

	public ResponseEntity<Integer> calculateResult(int id, List<Response> responses) {
		ResponseEntity<Integer> score = quizFeign.getQuizScore(responses);
		return score;
	}

}
