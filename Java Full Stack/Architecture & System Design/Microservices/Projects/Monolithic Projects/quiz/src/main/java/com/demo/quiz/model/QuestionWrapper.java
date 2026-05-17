package com.demo.quiz.model;

public class QuestionWrapper {
	private int id;
	private String questionTitle;
	private String option_1;
	private String option_2;
	private String option_3;
	private String option_4;
	
	
	public QuestionWrapper(int id, String questionTitle, String option_1, String option_2,
			String option_3, String option_4) {
		super();
		this.id = id;
		this.questionTitle = questionTitle;
		this.option_1 = option_1;
		this.option_2 = option_2;
		this.option_3 = option_3;
		this.option_4 = option_4;
	}
	

	public int getId() {
		return id;
	}


	public String getQuestionTitle() {
		return questionTitle;
	}


	public String getOption_1() {
		return option_1;
	}


	public String getOption_2() {
		return option_2;
	}


	public String getOption_3() {
		return option_3;
	}


	public String getOption_4() {
		return option_4;
	}


	@Override
	public String toString() {
		return "QuestionWrapper [id=" + id + ", questionTitle=" + questionTitle + ", option_1=" + option_1
				+ ", option_2=" + option_2 + ", option_3=" + option_3 + ", option_4=" + option_4 + "]";
	}
	
	
	
	
}
