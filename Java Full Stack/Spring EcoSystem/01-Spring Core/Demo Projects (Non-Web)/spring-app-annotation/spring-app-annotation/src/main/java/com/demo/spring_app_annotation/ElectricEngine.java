package com.demo.spring_app_annotation;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Primary
@Component
public class ElectricEngine implements Engine {
	@Override
	public void start() {
		System.out.println("Electric Engine Starts...");
		
	}

}
