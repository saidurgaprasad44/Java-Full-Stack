package com.demo.quiz.model;

public class Reponse {
	private int id;
	private String response;
	
	public Reponse(int id, String response) {
		super();
		this.id = id;
		this.response = response;
	}

	public int getId() {
		return id;
	}

	public String getResponse() {
		return response;
	}

	@Override
	public String toString() {
		return "Reponse [id=" + id + ", response=" + response + "]";
	}
	
	
}
