<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List, com.app.model.User" %>
<!DOCTYPE html>
<html>
<head>
    <title>Admin</title>
</head>
<body>
    <h2>Admin Page</h2>
    <h3>Welcome ${name}</h3>
    <h4>Users List</h4>
    <table border="1">
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Role</th>
            <th>Admin Action</th>
        </tr>
        <!-- Iterate over the 'users' attribute set in the Servlet -->
        <% List<User> users = (List<User>) request.getAttribute("users");
   for(User u : users) { %>
    <tr>
    	<td><%= u.getId() %></td>
    	<td><%= u.getUsername() %></td>
    	<td><%= u.getRole() %></td>
    	<td><button type="button">Delete</button><button type="button">Update</button></td>
    	
    </tr>
<% } %>
    </table>
</body>
</html>