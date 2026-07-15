package com.demo.spring_app_xml;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
    public static void main(String[] args) {
    	
    	ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
    	
//    	Car car = new Car(new GasEngine());
    	Car car = (Car) context.getBean("gasCarForSetter");
    	System.out.println("this is spring-app-xml project...");
    	car.drive();
    	car.specs();
    	((ClassPathXmlApplicationContext)context).close();
    }
}
