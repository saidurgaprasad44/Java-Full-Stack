<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List, com.app.model.User" %>
<!DOCTYPE html>
<html>
<head>
    <title>Admin - Manage Users</title>
</head>
<body>
    <h4>Manage Users</h4>
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
    
    <br><br>
    <a href="${pageContext.request.contextPath}/home">Home</a>
    <br><br>
    <form action="${pageContext.request.contextPath}/logout" method="get"><button type="submit">Logout</button></form>
</body>
</html>