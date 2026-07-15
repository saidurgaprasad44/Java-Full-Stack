package com.demo.spring_app_java_config;

import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

//@ComponentScan("com.demo.spring_app_java_config")
@Configuration
public class Config {

	@Bean // bean name "laptop"
	public Computer laptop() {
		return new Laptop();
	}
	
	@Bean // bean name "desktop"
	public Computer desktop() {
		return new Desktop();
	}
	
	@Bean // bean name "developerWithLaptopForConstructor"
	public Developer developerWithLaptopForConstructor(Laptop laptopForDeveloper) { //Constructor injection with dependency Laptop bean
		return new Developer(laptopForDeveloper); //passing dependency as a parameter, spring decides which bean by matching the type (autowiring)
	}
	
	@Bean // bean name "developerWithDesktopForConstructor"
	public Developer developerWithDesktopForConstructor() { //Constructor injection with dependency Desktop bean
		return new Developer(desktop()); 
	}
	
	
	@Bean // bean name "developerPrototypeBean"
	@Scope("prototype")
	public Developer developerPrototypeBean() {
		return new Developer();
	}
	
	@Bean // bean name "developerWithLaptopForSetter"
	public Developer developerWithLaptopForSetter() { // Setter injection
		Developer dev = developerPrototypeBean();
		dev.setComp(laptop());
		return dev;
	}
	
	@Bean // bean name "developerWithLaptop"
	public Developer developerWithDesktopForSetter(Desktop desktop) { // setter injection
		Developer dev = developerPrototypeBean();
		dev.setComp(desktop); //passing dependency as a parameter, spring decides which bean by matching the type (autowiring)
		return dev;
	}
}
