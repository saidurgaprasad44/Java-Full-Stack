<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Signup</title>
</head>
<body>
	<h2>User Sign-up</h2>
 
    <form action="signup" method="post">
        Username: <input type="text" name="username" required/><br><br>
        Password: <input type="password" name="password" required/><br><br>
        Role: <input type="radio" name="role" value="admin" required/> Admin <input type="radio" name="role" value="basic" required/> Basic <br><br>
        <input type="submit" value="Submit" />		<a href="login.jsp"> Go back to Login page</a>
    </form>
    
    <p style="color:red">${errorMsg}</p>
</body>
</html>