Java Backend Application using Maven for REST API CRUD


MVC Mapping:
Layer:		Component:
Resources	Student.java
Service		StudentService.java
DAO		StudentDao.java, DBUtil.java
Model		Student.java
Config		web.xml, pom.xml


===============================================================================================================================================================================
Setup & Running Guide:
===============================================================================================================================================================================

Clone the repo from GitHub - https://github.com/saidurgaprasad44/Student.git

Recommended IDE - Eclipse EE...

Supported Tomcat Version - 9

Java Version - 8


URL:	http://localhost:8082/AdminUser/

=======================================================================================================================================================================
Database Setup:
=======================================================================================================================================================================

Database: PostgreSQL
Database Name: student


CREATE TABLE student (
    rollNo SERIAL PRIMARY KEY,
    name VARCHAR(50),
    subject VARCHAR(50)
);
 
INSERT INTO student (rollNo, name, subject) VALUES (1, 'Sai', 'Computers');

=======================================================================================================================================================================



