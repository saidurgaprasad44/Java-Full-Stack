package com.demo.spring_app_annotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class Car {
	
//	@Autowired //field injection
//	@Qualifier("favoriteEngine") // by name
	private Engine engine;
	
//	@Autowired
//	public Car(@Qualifier("favoriteEngine") Engine engine) { //constructor injection
//		this.engine = engine;
//	}
	
	public Car() {
		
	}
	
	@Qualifier("favoriteEngine")
	@Autowired
	public void setEngine(Engine engine) { //setter injection
		this.engine = engine;
	}

	
	public void drive() {
		engine.start();
		System.out.println("driving the car...");
	}
	
	public void specs() {
		System.out.println("Its a good car, with 5000 horse power...");
	}
}
