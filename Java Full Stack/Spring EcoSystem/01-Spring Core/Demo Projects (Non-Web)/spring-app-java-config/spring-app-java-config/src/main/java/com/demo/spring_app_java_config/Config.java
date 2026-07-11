package com.demo.spring_app_java_config;

import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

//@ComponentScan("com.demo.spring_app_java_config")
@Configuration
public class Config {

	@Bean
	public Laptop laptop() {
		return new Laptop();
	}
	
//	@Bean
//	public Computer desktop() {
//		return new Desktop();
//	}
	
	@Bean
	public Developer developerOnDesktop(Laptop laptop1) { //Constructor injection with dependency "desktop"
		return new Developer(laptop1);
	}
	
	@Bean
	public Developer developer() { //Constructor injection without dependency
		return new Developer();
	}
	
//	@Bean
//	@Scope("prototype")
//	public Developer developerPrototype() {
//		return new Developer();
//	}
	
//	@Bean
//	public Developer developerOnLaptop() { // Setter injection
//		Developer dev = developerPrototype();
//		dev.setComp(laptop());
//		return dev;
//	}
//	
//	@Bean
//	public Developer developerOnDesktop() { // setter injection
//		Developer dev = developerPrototype();
//		dev.setComp(desktop());
//		return dev;
//	}
}
