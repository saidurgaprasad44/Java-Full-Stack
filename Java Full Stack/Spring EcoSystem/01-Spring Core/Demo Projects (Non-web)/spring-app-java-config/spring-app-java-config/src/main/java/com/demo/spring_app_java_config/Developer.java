package com.demo.spring_app_java_config;

//import org.springframework.beans.factory.annotation.Autowired;

public class Developer {
	
	//@Autowired
	private Computer comp;
	
	//Constructor Injection
	public Developer(Computer comp) {
		this.comp=comp;
	}
	
	public Developer() {
		
	}
	
	//Setter Injection
	public void setComp(Computer comp) {
		this.comp=comp;
	}
	
	public void build() {
		System.out.println("Hello I am a developer");
		System.out.print("I am ");
		comp.compile();
	}
	
	public void skillSet() {
		System.out.println("Full Stack");
	}
}
