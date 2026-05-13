package com.example.springBootApp;

import org.springframework.stereotype.Component;

@Component
public class GasEngine implements Engine {

	@Override
	public void start() {
		System.out.println("Gas engine Vroom!");
	}

}
