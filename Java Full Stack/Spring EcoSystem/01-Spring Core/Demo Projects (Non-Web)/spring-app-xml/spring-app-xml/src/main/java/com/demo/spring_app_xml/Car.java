package com.demo.spring_app_xml;




public class Car {

	Engine engine;
	
//	public Car(Engine engine1) {
//		this.engine1 = engine1;
//	}
	public void setEngine(Engine engine) {
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
