Spring Boot Web App implementing REST CRUD, Spring Data JPA



Package structure:
Layer		Component
-----------------------------------------------------------
Controller	HomeController.java, ProductController.java
Service		ProductService.java
Model		Product.java (Entity)
Repo		ProductRepo.java   -->  used Spring Data JPA
Config		web.xml


=======================================================================================================================================================================
Setup and Running Guide:
=======================================================================================================================================================================
Clone the repo from GitHub - https://github.com/saidurgaprasad44/AdminUser.git

Recommended IDE - Spring Tools for Eclipse...

Embedded Tomcat

Java Version - 17

URL: http://localhost:8080/api/products

=======================================================================================================================================================================
Database Setup:
=======================================================================================================================================================================

Database: PostgreSQL
Database Name: eShop


CREATE TABLE product (
    id SERIAL PRIMARY KEY,
    name VARCHAR(255),
    price INT
);
 
INSERT INTO product (id, name, price) VALUES (1, 'fan', 2000);

=======================================================================================================================================================================


