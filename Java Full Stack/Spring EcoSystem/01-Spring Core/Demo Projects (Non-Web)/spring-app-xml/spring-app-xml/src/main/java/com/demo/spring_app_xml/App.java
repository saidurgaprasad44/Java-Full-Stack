package com.demo.spring_app_xml;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
    public static void main(String[] args) {
    	
    	ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
    	
//    	Car car = new Car(new GasEngine());
    	Car car = (Car) context.getBean("car");
    	car.drive();
    	((ClassPathXmlApplicationContext)context).close();
    }
}
