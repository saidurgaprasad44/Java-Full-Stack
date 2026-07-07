package com.example.springBootApp;



import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SpringBootAppApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(SpringBootAppApplication.class, args);
		
//		Dev dev=new Dev(new Laptop());
		Car car=context.getBean(Car.class);
		
		
		car.drive();
	}

}
