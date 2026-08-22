package com.demo.quiz_service.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.demo.quiz_service.model.Quiz;
@Repository
public interface QuizRepo extends JpaRepository<Quiz, Integer>{
}
