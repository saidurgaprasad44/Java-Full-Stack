package com.demo.spring_app_java_config;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
        

        Developer dev = (Developer)context.getBean("developerOnDesktop");
        dev.build();
        dev.skillSet();
        
        ((AnnotationConfigApplicationContext)context).close();
    }
}
