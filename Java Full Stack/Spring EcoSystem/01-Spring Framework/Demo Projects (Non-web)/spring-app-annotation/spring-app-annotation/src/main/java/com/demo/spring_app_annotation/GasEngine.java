package com.demo.spring_app_annotation;

import org.springframework.stereotype.Component;

@Component("favoriteEngine")
//@Component
public class GasEngine implements Engine {

	@Override
	public void start() {
		System.out.println("Gas Engine starts....");
		
	}

}
