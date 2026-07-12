package com.demo.spring_app_annotation;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
//import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext("com.demo.spring_app_annotation");
//        ApplicationContext xmlContext = new ClassPathXmlApplicationContext("spring.xml");
        
        Car car = (Car) context.getBean("car");
//        Car car = (Car) xmlContext.getBean("car");      
        System.out.println("this is spring-app-annotation project...");
        car.drive();
        car.specs();
        ((AnnotationConfigApplicationContext)context).close();
//        ((ClassPathXmlApplicationContext)xmlContext).close();
    }
}
