package com.demo.quiz.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.demo.quiz.model.Quiz;
import com.demo.quiz.model.Reponse;
import com.demo.quiz.repo.QuestionRepo;
import com.demo.quiz.repo.QuizRepo;
import com.demo.quiz.model.QuestionWrapper;
import com.demo.quiz.controller.QuestionController;
import com.demo.quiz.model.Question;

@Service
public class QuizService {
	
	QuizRepo quizRepo;
	QuestionRepo questionRepo;
	
	public QuizService(QuizRepo quizRepo, QuestionRepo questionRepo, QuestionController questionController) {
		this.quizRepo=quizRepo;
		this.questionRepo=questionRepo;
	}
	
	public ResponseEntity<String> createQuiz(String category, int numQ, String title) {
		List<Question> questions = questionRepo.findRandomQuestionsByCategory(category, numQ);
		
		Quiz quiz= new Quiz();
		quiz.setTitle(title);
		quiz.setQuestions(questions);
		
		quizRepo.save(quiz);
		return new ResponseEntity<>("success", HttpStatus.CREATED);
	}

	public ResponseEntity<List<QuestionWrapper>> getQuiz(int id) {
		Optional<Quiz> quiz = quizRepo.findById(id);
		
		List<Question> questionsFromDB = quiz.get().getQuestions();
		
		List<QuestionWrapper> questionsForUser = new ArrayList<>();
		
		questionsFromDB.forEach(question->{
			QuestionWrapper questionForUser = new QuestionWrapper(question.getId(), question.getQuestionTitle(), question.getOption_1(), question.getOption_2(), question.getOption_3(), question.getOption_4());
			questionsForUser.add(questionForUser);
		});
		
		System.out.println();
		questionsForUser.forEach(question -> System.out.println(question));
		
		return new ResponseEntity<>(questionsForUser, HttpStatus.OK);
	}

	public ResponseEntity<Integer> calculateResult(int id, List<Reponse> responses) {
		List<Question> questions = quizRepo.findById(id).get().getQuestions();
		
		int score=0;
		int i=0;
		
		for(Question question: questions) {
			if(question.getRight_answer().equals(responses.get(i).getResponse())){
				score++;
			}
			i++;
		}
		
		return new ResponseEntity<>(score, HttpStatus.CREATED);
	}

}
