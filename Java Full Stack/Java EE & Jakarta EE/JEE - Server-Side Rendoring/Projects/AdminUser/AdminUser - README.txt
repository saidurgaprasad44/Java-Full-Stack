Java Dynamic Web App without Spring


Complete Java Web App (MVC using servlet/JSP):


Use Case:
User logs in → credentials validated from DB → admin page shows “Welcome <<username>>”


MVC Mapping:
Layer:		Component:
View		login.jsp, admin.jsp, singup.jsp, success.jsp
Controller	LoginServlet, SignupServlet
Model		User (Entity), UserDao(Dao), UserService(Service)
Util		DBUtil
Config		web.xml


Project Structure:
 
MyWebApp/
├── src/
│   └── com/app/
│        ├── controller/
│        │    ├── LoginServlet.java
│        │    └── SignupServlet.java
│        ├── model/
│        │    └── User.java
│        ├── dao/
│        │    ├── UserDao.java
│        │    └── DBUtil.java
│        └── service/
│              └── UserService.java
└── WebContent/
     ├── login.jsp
     ├── admin.jsp
     ├── signup.jsp
     ├── success.jsp
     └── WEB-INF/
          ├── web.xml
          └── lib/
               └── posgresql-xx.x.x.jar

=======================================================================================================================================================================
Setup and Running Guide:
=======================================================================================================================================================================
Clone the repo from GitHub - https://github.com/saidurgaprasad44/AdminUser.git

Recommended IDE - Eclipse EE...

Supported Tomcat Version - 9

Java Version - 17

URL: http://localhost:8080/student/webapi/students

=======================================================================================================================================================================
Database Setup:
=======================================================================================================================================================================

Database: PostgreSQL
Database Name: AdminUser


CREATE TYPE role_type AS ENUM ('admin', 'basic');

CREATE TABLE users (
    id SERIAL PRIMARY KEY,
    username VARCHAR(50),
    password VARCHAR(50),
    role role_type
);
 
INSERT INTO users (id, username, password) VALUES (1, 'Sai', 'admin123', 'ADMIN');

=======================================================================================================================================================================


