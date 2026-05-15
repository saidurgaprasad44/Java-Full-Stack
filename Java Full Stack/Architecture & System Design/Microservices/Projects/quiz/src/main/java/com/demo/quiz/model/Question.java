package com.demo.quiz.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Question {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String category;
	private String questionTitle;
	private String option_1;
	private String option_2;
	private String option_3;
	private String option_4;
	private String right_answer;
	private String difficulty_level;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getQuestionTitle() {
		return questionTitle;
	}
	public void setQuestionTitle(String questionTitle) {
		this.questionTitle = questionTitle;
	}
	public String getOption_1() {
		return option_1;
	}
	public void setOption_1(String option_1) {
		this.option_1 = option_1;
	}
	public String getOption_2() {
		return option_2;
	}
	public void setOption_2(String option2) {
		this.option_2 = option2;
	}
	public String getOption_3() {
		return option_3;
	}
	public void setOption_3(String option3) {
		this.option_3 = option3;
	}
	public String getOption_4() {
		return option_4;
	}
	public void setOption_4(String Option_4) {
		this.option_4 = Option_4;
	}
	public String getRight_answer() {
		return right_answer;
	}
	public void setRight_answer(String right_answer) {
		this.right_answer = right_answer;
	}
	public String getDifficulty_level() {
		return difficulty_level;
	}
	public void setDifficulty_level(String difficulty_level) {
		this.difficulty_level = difficulty_level;
	}
	public Question() {
		super();
	}
	
	@Override
	public String toString() {
		return "Question [id=" + id + ", category=" + category + ", questionTitle=" + questionTitle + ", option_1="
				+ option_1 + ", option2=" + option_2 + ", option3=" + option_3 + ", Option_4=" + option_4 + ", right_answer="
				+ right_answer + ", difficulty_level=" + difficulty_level + "]";
	}
	
	
}
