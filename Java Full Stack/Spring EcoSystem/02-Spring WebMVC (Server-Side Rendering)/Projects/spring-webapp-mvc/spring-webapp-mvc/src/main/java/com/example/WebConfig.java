package com.example;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.example")
//this class replaces the dispatcher-servlet.xml file and configures the Spring MVC infrastructure programmatically
public class WebConfig { 

	@Bean
	public InternalResourceViewResolver viewResolver() {

	    InternalResourceViewResolver resolver = new InternalResourceViewResolver();

	    resolver.setPrefix("/WEB-INF/views/");
	    resolver.setSuffix(".jsp");

	    return resolver;
	}

}
