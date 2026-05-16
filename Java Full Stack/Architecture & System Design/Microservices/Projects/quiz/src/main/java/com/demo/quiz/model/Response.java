package com.demo.quiz.model;

public class Response {
	private int id;
	private String response;
	
	public Response(int id, String response) {
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
		return "Response [id=" + id + ", response=" + response + "]";
	}
	
	
}
