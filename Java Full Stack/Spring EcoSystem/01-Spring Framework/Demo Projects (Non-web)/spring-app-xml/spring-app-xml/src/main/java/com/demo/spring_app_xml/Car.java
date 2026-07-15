package com.demo.spring_app_xml;




public class Car {

	private Engine engine;
	
	public Car(Engine engine) { //constructor injection
		this.engine = engine;
	}
	
	public Car() {
	
	}
	
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
