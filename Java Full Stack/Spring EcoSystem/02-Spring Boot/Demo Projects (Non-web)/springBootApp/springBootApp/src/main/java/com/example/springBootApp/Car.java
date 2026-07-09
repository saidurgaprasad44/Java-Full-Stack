package com.example.springBootApp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class Car {
//	@Autowired 			//Field Injection
//	@Qualifier("gasEngine")
	private Engine engine;
//	public Car(Engine engine) {		//Constructor Injection
//		this.engine=engine;
//	}
	@Autowired
	public void setEngine(@Qualifier("gasEngine") Engine engine) {
		this.engine=engine;
	}
	
	public void drive() {
		System.out.println("This is a car");
		engine.start();
	}
}
