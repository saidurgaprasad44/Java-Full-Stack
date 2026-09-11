<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Home</title>
</head>
<body>
    <h2>Home Page</h2>
    <h3>Welcome ${username}</h3>
    <% String role = (String)request.getAttribute("role"); 
    if ("ADMIN".equals(role.toUpperCase())){%>
    	<a href="admin">Administrator</a>
    <% } %>
    
    <br><br>
    <form action="${pageContext.request.contextPath}/logout" method="get">
		<button type="submit">Logout</button>
	</form>
</body>
</html>