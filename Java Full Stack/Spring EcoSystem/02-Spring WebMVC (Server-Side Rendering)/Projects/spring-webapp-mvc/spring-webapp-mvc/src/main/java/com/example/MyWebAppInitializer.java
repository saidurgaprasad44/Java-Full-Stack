package com.example;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

//This class replaces the web.xml file and configures the DispatcherServlet programmatically
public class MyWebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

    // 1. Point to your root application context configuration (Services, Security, Repositories)
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return null; // Return null if you don't have separate root configurations yet
    }

    // 2. Point to your Web/MVC configuration class (ViewResolvers, Controllers, Interceptors)
    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class<?>[] { WebConfig.class }; 
    }

    // 3. This replaces your <servlet-mapping> <url-pattern>/</url-pattern> block
    @Override
    protected String[] getServletMappings() {
        return new String[] { "/" };
    }
}
