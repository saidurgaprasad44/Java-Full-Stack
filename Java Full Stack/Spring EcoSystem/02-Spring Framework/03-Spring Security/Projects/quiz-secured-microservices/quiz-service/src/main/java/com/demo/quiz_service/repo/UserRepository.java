package com.demo.quiz_service.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.quiz_service.entity.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByUsername(String username);
}