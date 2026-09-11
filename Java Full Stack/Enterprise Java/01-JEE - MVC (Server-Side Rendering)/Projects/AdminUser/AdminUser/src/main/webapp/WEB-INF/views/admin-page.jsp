<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Admin</title>
</head>
<body>
    <h1>Admin Page</h1>
    <h3>Welcome ${username}</h3>
    <a href="${pageContext.request.contextPath}/admin/manageusers">Manage Users</a>
    <br><br>
    <form action="${pageContext.request.contextPath}/logout" method="get">
		<button type="submit">Logout</button>
	</form>
</body>
</html>