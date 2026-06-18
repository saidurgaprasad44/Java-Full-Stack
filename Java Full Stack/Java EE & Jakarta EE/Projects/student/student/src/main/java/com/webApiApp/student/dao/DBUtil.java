package com.webApiApp.student.dao;
 
import java.sql.Connection;
import java.sql.DriverManager;
 
public class DBUtil {
 
    public static Connection getConnection() throws Exception {
        Class.forName("org.postgresql.Driver");
        return DriverManager.getConnection(
        	"jdbc:postgresql://localhost:5432/student", 
            "postgres", 
            "postgres"
        );
    }
}