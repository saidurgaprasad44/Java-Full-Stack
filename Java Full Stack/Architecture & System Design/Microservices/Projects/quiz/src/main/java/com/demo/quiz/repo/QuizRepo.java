package com.demo.quiz.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.demo.quiz.model.Quiz;
@Repository
public interface QuizRepo extends JpaRepository<Quiz, Integer>{
}
